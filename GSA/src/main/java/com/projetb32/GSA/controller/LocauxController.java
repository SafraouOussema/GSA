package com.projetb32.GSA.controller;


import com.projetb32.GSA.entity.Locaux;
import com.projetb32.GSA.repository.CompanyRepository;
import com.projetb32.GSA.repository.LocauxRepository;
import com.projetb32.GSA.service.LocauxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/application")
public class LocauxController {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private LocauxRepository locauxRepository;

    @Autowired
    private LocauxService locauxService;

    @GetMapping("/locaus")
    public ResponseEntity<List<Locaux>> GetLocaux() {
        List<Locaux> listLocaux = null;
        listLocaux = locauxRepository.findAll();
        if (listLocaux.isEmpty())
            return ResponseEntity.noContent().build();

        return new ResponseEntity<>(listLocaux, HttpStatus.OK);
    }

    @GetMapping("/locaus/{locausId}")
    public ResponseEntity<List<Locaux>> retreiveCategoryById(@PathVariable long locausId) {
        List<Locaux> locausList;
        locausList = locauxService.getLocauxByCompany(locausId);


        return new ResponseEntity<>(locausList, HttpStatus.OK);

    }

    @PostMapping("/locaus/{companyId}")
    public ResponseEntity<Locaux> addCalendar(@RequestBody Locaux locaux,  @PathVariable long companyId) {
        Locaux calendarLocal = locauxService.addlocaux(locaux,companyId);

        if (calendarLocal == null)
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(calendarLocal, HttpStatus.OK);

    }


    @DeleteMapping("/locaus/{locauId}")
    public ResponseEntity<Locaux> deleteCalendar(@PathVariable long locauId) {
        locauxRepository.deleteById(locauId);
        return ResponseEntity.accepted().build();
    }



}
