package com.projetb32.GSA.controller;

import com.projetb32.GSA.entity.CompanyUser;
import com.projetb32.GSA.repository.CompanyUserRepository;
import com.projetb32.GSA.repository.CompanyRepository;
import com.projetb32.GSA.repository.UserRepository;
import com.projetb32.GSA.service.CompanyService;
import com.projetb32.GSA.service.CompanyUserService;
import com.projetb32.GSA.service.EmailSenderService;
import com.projetb32.GSA.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Date;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/application")
public class CompanyUserController {

    @Autowired
    private CompanyUserRepository companyUserRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyUserService companyUserService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailSenderService emailSenderService;

    @GetMapping("/companyusers")
    public ResponseEntity<List<CompanyUser>> GetCalendar() {
        List<CompanyUser> listCompanyUser = null;
        listCompanyUser = companyUserRepository.findAll();
        if (listCompanyUser.isEmpty())
            return ResponseEntity.noContent().build();

        return new ResponseEntity<>(listCompanyUser, HttpStatus.OK);
    }

    @GetMapping("/companyusers/{idusers}/{idcompany}")
    public ResponseEntity<List<CompanyUser>> retrieveCategoryByUserIdAndCompanyId(@PathVariable long idusers,
            @PathVariable long idcompany) {
        List<CompanyUser> listCompanyUser;
        listCompanyUser = companyUserService.getCompanyUserByUserIdAndCompanyId(idusers, idcompany);

        return new ResponseEntity<>(listCompanyUser, HttpStatus.OK);

    }

    @GetMapping("/companyusers/{username}")
    public ResponseEntity<List<CompanyUser>> retrieveCategoryByUserI(@PathVariable String username) {
        List<CompanyUser> listCompanyUser;

        User findUser = userRepository.findByUsername(username).get();

        listCompanyUser = companyUserService.getCompanyUserByUserId(findUser.getId());
        return new ResponseEntity<>(listCompanyUser, HttpStatus.OK);
    }

    @PostMapping("/companyusers/{username}/{companyId}/{password}")
    public ResponseEntity<CompanyUser> addCompanyUser(@PathVariable String username,
            @PathVariable long companyId, @PathVariable String password) {

        User findUser = userRepository.findByUsername(username).get();

        CompanyUser companyUserLocal = companyUserService.addStep(findUser.getId(), companyId);

        if (companyUserLocal == null) {
            return ResponseEntity.noContent().build();
        }

        // String body = "your password thnx to change it " + password;

        String body = "Hello ! " + findUser.getName()
                + "\n You can now use this new credential to login into the application. \n"
                + "Url : " + " https://gsapwa.netlify.app/ \n" + "Your User Name : " + findUser.getUsername() + "\n"
                + "Your Password : " + password + "\n";

        emailSenderService.sendEmail(findUser.getEmail(), "GSA Account info", body);

        return new ResponseEntity<>(companyUserLocal, HttpStatus.OK);

    }

    @DeleteMapping("/companyusers/{companyusersId}")
    public ResponseEntity<CompanyUser> deleteCalendar(@PathVariable long companyusersId) {
        companyUserRepository.deleteById(companyusersId);
        return ResponseEntity.accepted().build();
    }

}
