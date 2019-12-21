package com.projetb32.GSA.controller;


import com.projetb32.GSA.entity.Fiche;
import com.projetb32.GSA.repository.FicheReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/application")
public class FicheController {



    @Autowired
    private FicheReposity ficheRepository;


    @GetMapping("/fiches")
    public ResponseEntity<List<Fiche>> GetFiche() {
        List<Fiche> listfiche = null;
        listfiche = ficheRepository.findAll();
        if (listfiche.isEmpty())
            return ResponseEntity.noContent().build();

        return new ResponseEntity<>(listfiche, HttpStatus.OK);
    }


    @PostMapping("/fiches")
    public ResponseEntity<Fiche> addCompany(@RequestBody Fiche fiche) {
        Fiche ficheLocal = null;
        ficheLocal = ficheRepository.save(fiche);

        if (ficheLocal == null)
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(ficheLocal, HttpStatus.OK);

    }


    @DeleteMapping("/fiches/{ficheId}")
    public ResponseEntity<Fiche> deleteFiche(@PathVariable long ficheId) {
        ficheRepository.deleteById(ficheId);
        return ResponseEntity.accepted().build();
    }



}
