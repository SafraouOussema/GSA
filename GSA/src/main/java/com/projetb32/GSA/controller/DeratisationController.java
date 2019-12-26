package com.projetb32.GSA.controller;


import com.projetb32.GSA.entity.Deratisation;
import com.projetb32.GSA.repository.DeratisationRepository;
import com.projetb32.GSA.repository.LocauxRepository;
import com.projetb32.GSA.repository.ProduitRepository;
import com.projetb32.GSA.service.DeratisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/application")
public class DeratisationController {


    @Autowired
    private DeratisationRepository deratisationRepository;


    @Autowired
    private LocauxRepository locauxRepository;



    @Autowired
    private DeratisationService deratisationService;

    @Autowired
    private ProduitRepository produitRepository;

    @GetMapping("/deratisations")
    public ResponseEntity<List<Deratisation>> GetDeratisation() {
        List<Deratisation> listDeratisation = null;
        listDeratisation = deratisationRepository.findAll();
        if (listDeratisation.isEmpty())
            return ResponseEntity.noContent().build();

        return new ResponseEntity<>(listDeratisation, HttpStatus.OK);
    }

    @GetMapping("/deratisations/{deratisationId}")
    public ResponseEntity<List<Deratisation>> retreiveCategoryById(@PathVariable long deratisationId) {
        List<Deratisation> deratisationList;
        deratisationList = deratisationService.getderatisationByFiche(deratisationId);


        return new ResponseEntity<>(deratisationList, HttpStatus.OK);

    }


    @PostMapping("/deratisations/{ficheId}/{locauxId}/{produitId}")
    public ResponseEntity<Deratisation> addDeratisation(@RequestBody Deratisation deratisation,@PathVariable long ficheId,@PathVariable long locauxId, @PathVariable long produitId) {
        Deratisation deratisationLocal = deratisationService.addDeratisation(deratisation,ficheId, locauxId,produitId);

        if (deratisationLocal == null)
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(deratisationLocal, HttpStatus.OK);

    }


    @DeleteMapping("/deratisations/{deratisationId}")
    public ResponseEntity<Deratisation> deleteDeratisation(@PathVariable long deratisationId) {
        deratisationRepository.deleteById(deratisationId);
        return ResponseEntity.accepted().build();
    }



}
