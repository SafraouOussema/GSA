package com.projetb32.GSA.service;

import com.projetb32.GSA.entity.FicheProduit;
import com.projetb32.GSA.entity.FicheProduitPk;
import com.projetb32.GSA.repository.FicheProduitRepository;
import com.projetb32.GSA.repository.FicheReposity;
import com.projetb32.GSA.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FicheProduitService {

    @Autowired
    private FicheReposity ficheReposity;

    @Autowired
    private FicheProduitRepository ficheProduitRepository;
    @Autowired
    private ProduitRepository produitRepository;


    public FicheProduit addFicheProduit(long fiche_id, long produit_id) {
        FicheProduit p = new FicheProduit();
        FicheProduitPk pp = new FicheProduitPk();
        pp.setFiche(ficheReposity.findById(fiche_id).get());
        pp.setProduit(produitRepository.findById(produit_id).get());
        p.setFicheProduitPk(pp);
        return ficheProduitRepository.save(p);
    }

    public List<FicheProduit> getAllFicheProduit() {
        return ficheProduitRepository.findAll();
    }

    public void deleteFicheProduit( Long produit_id,Long fiche_id) {

        ficheProduitRepository.delete(new FicheProduit
                (new FicheProduitPk(produitRepository.findById(produit_id).get()
                        ,ficheReposity.findById(fiche_id).get()
                        )));
    }
}
