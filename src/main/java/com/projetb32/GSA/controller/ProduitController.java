package com.projetb32.GSA.controller;


import com.projetb32.GSA.entity.Produit;
import com.projetb32.GSA.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/application")
public class ProduitController {


    @Autowired
    private ProduitRepository produitRepository;


    @GetMapping("/produits")
    public ResponseEntity<List<Produit>> GetProduit() {
        List<Produit> listProduit = null;
        listProduit = produitRepository.findAll();
        if (listProduit.isEmpty())
            return ResponseEntity.noContent().build();

        return new ResponseEntity<>(listProduit, HttpStatus.OK);
    }


    @PostMapping("/produits")
    public ResponseEntity<Produit> addCalendar(@RequestBody Produit produit) {
        Produit produitLocal = produitRepository.save(produit);

        if (produitLocal == null)
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(produitLocal, HttpStatus.OK);

    }


    @DeleteMapping("/produits/{produitId}")
    public ResponseEntity<Produit> deleteCalendar(@PathVariable long produitId) {
        produitRepository.deleteById(produitId);
        return ResponseEntity.accepted().build();
    }


}
