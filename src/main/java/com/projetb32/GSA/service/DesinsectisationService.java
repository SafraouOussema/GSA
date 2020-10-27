package com.projetb32.GSA.service;

import com.projetb32.GSA.entity.Desinsectisation;
import com.projetb32.GSA.entity.Fiche;
import com.projetb32.GSA.repository.DesinsectisationRepository;
import com.projetb32.GSA.repository.FicheReposity;
import com.projetb32.GSA.repository.LocauxRepository;
import com.projetb32.GSA.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DesinsectisationService {




    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private LocauxRepository locauxRepository;
    @Autowired
    private DesinsectisationRepository desinsectisationRepository;

    @Autowired
    private FicheReposity ficheReposity;



    public Desinsectisation addDesinsectisation(Desinsectisation desinsectisation,Long ficheId, Long locauxId, long produitId) {
        desinsectisation.setFiche(ficheReposity.findById(ficheId).get());
        desinsectisation.setLocaux(locauxRepository.findById(locauxId).get());
        desinsectisation.setProduit(produitRepository.findById(produitId).get());


        return desinsectisationRepository.save(desinsectisation);
    }


    public List<Desinsectisation> getDesinsectisationByFiche(long ficheId) {
        Fiche fiche = ficheReposity.findById(ficheId).get();
        return desinsectisationRepository.findDesinsectisationByFiche(fiche);
    }

}
