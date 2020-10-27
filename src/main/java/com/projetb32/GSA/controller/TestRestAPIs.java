package com.projetb32.GSA.controller;

import com.projetb32.GSA.entity.User;
import com.projetb32.GSA.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TestRestAPIs {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/api/test/user")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String userAccess() {
        return ">>> User Contents!";
    }

    @GetMapping("/api/test/pm")
    @PreAuthorize("hasRole('PM') or hasRole('ADMIN')")
    public String projectManagementAccess() {
        return ">>> Project Management Board";
    }

    @GetMapping("/api/test/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return ">>> Admin Contents";
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> GetUser() {
        List<User> listuser = null;
        listuser = userRepository.findAll();
        if (listuser.isEmpty())
            return ResponseEntity.noContent().build();

        return new ResponseEntity<>(listuser, HttpStatus.OK);
    }

}
