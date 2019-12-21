package com.projetb32.GSA.controller;


import com.projetb32.GSA.entity.FicheProduit;
import com.projetb32.GSA.service.FicheProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/application")
public class FicheProduitController {


    @Autowired
    private FicheProduitService ficheProduitService;

    @GetMapping("/ficheProduits")
    public ResponseEntity<List<FicheProduit>> retreiveFicheProduit() {
        return new ResponseEntity<>(ficheProduitService.getAllFicheProduit(), HttpStatus.OK);

    }


    @PostMapping("/ficheProduits/{produitId}/{ficheId}")
    public ResponseEntity<FicheProduit> addFicheProduit(@PathVariable long produitId, @PathVariable long ficheId) {


        FicheProduit ficheProduitLocal = ficheProduitService.addFicheProduit(produitId, ficheId);

        if (ficheProduitLocal == null)
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(ficheProduitLocal, HttpStatus.OK);
    }


    @DeleteMapping("/ficheProduits/{produitId}/{ficheId}")
    public ResponseEntity<FicheProduit> deleteFicheProduit(@PathVariable long produitId, @PathVariable long ficheId) {
        ficheProduitService.deleteFicheProduit(produitId, ficheId);
        return ResponseEntity.accepted().build();
    }
}
