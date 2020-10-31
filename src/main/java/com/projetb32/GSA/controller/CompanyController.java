package com.projetb32.GSA.controller;


import com.projetb32.GSA.entity.Company;
import com.projetb32.GSA.entity.Locaux;
import com.projetb32.GSA.repository.CompanyRepository;
import com.projetb32.GSA.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/application")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyService companyService;

    @GetMapping("/companys")
    public ResponseEntity<List<Company>> GetCompany() {
        List<Company> listcompany = null;
        listcompany = companyRepository.findAll();
        if (listcompany.isEmpty())
            return ResponseEntity.noContent().build();

        return new ResponseEntity<>(listcompany, HttpStatus.OK);
    }
    @GetMapping("/companys/{companysId}")
    public ResponseEntity<Optional<Company>> retreiveCategoryById(@PathVariable long companysId) {
        Optional<Company> locausList;
        locausList = companyService.getCompanyById(companysId);

        if (!locausList.isPresent())
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(locausList, HttpStatus.OK);

    }




    @PostMapping("/companys")
    public ResponseEntity<Company> addCompany(@RequestBody Company company) {
        Company companyLocal = null;
        companyLocal = companyRepository.save(company);

        if (companyLocal == null)
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(companyLocal, HttpStatus.OK);

    }


    @DeleteMapping("/companys/{companyId}")
    public ResponseEntity<Company> deleteCompany(@PathVariable long companyId) {
        companyRepository.deleteById(companyId);
        return ResponseEntity.accepted().build();
    }





}
