package com.projetb32.GSA.controller;


import com.projetb32.GSA.entity.Desinsectisation;
import com.projetb32.GSA.repository.DesinsectisationRepository;
import com.projetb32.GSA.repository.LocauxRepository;
import com.projetb32.GSA.repository.ProduitRepository;
import com.projetb32.GSA.service.DeratisationService;
import com.projetb32.GSA.service.DesinsectisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/application")
public class DesinsectisationController {



    @Autowired
    private DesinsectisationRepository desinsectisationRepository;


    @Autowired
    private LocauxRepository locauxRepository;



    @Autowired
    private DesinsectisationService desinsectisationService;

    @Autowired
    private ProduitRepository produitRepository;

    @GetMapping("/desinsectisations")
    public ResponseEntity<List<Desinsectisation>> GetDesinsectisation() {
        List<Desinsectisation> listDesinsectisation = null;
        listDesinsectisation = desinsectisationRepository.findAll();
        if (listDesinsectisation.isEmpty())
            return ResponseEntity.noContent().build();

        return new ResponseEntity<>(listDesinsectisation, HttpStatus.OK);
    }


    @GetMapping("/desinsectisations/{desinsectisationsId}")
    public ResponseEntity<List<Desinsectisation>> retreiveCategoryById(@PathVariable long desinsectisationsId) {
        List<Desinsectisation> locausList;
        locausList = desinsectisationService.getDesinsectisationByFiche(desinsectisationsId);


        return new ResponseEntity<>(locausList, HttpStatus.OK);

    }


    @PostMapping("/desinsectisations/{ficheId}/{locauxId}/{produitId}")
    public ResponseEntity<Desinsectisation> addDesinsectisation(@RequestBody Desinsectisation desinsectisation,@PathVariable long ficheId,@PathVariable long locauxId, @PathVariable long produitId) {
        Desinsectisation desinsectisationLocal = desinsectisationService.addDesinsectisation(desinsectisation,ficheId, locauxId,produitId);

        if (desinsectisationLocal == null)
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(desinsectisationLocal, HttpStatus.OK);

    }


    @DeleteMapping("/desinsectisations/{desinsectisationId}")
    public ResponseEntity<Desinsectisation> deleteDesinsectisation(@PathVariable long desinsectisationId) {
        desinsectisationRepository.deleteById(desinsectisationId);
        return ResponseEntity.accepted().build();
    }



}
