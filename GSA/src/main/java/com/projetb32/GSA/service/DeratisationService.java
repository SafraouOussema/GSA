package com.projetb32.GSA.service;


import com.projetb32.GSA.entity.Deratisation;
import com.projetb32.GSA.repository.DeratisationRepository;
import com.projetb32.GSA.repository.FicheReposity;
import com.projetb32.GSA.repository.LocauxRepository;
import com.projetb32.GSA.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeratisationService {


    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private LocauxRepository locauxRepository;
    @Autowired
    private DeratisationRepository deratisationRepository;

    @Autowired
    private FicheReposity ficheReposity;

    public Deratisation addDeratisation(Deratisation deratisation,Long ficheId, Long locauxId, long produitId) {
        deratisation.setFiche(ficheReposity.findById(ficheId).get());
        deratisation.setLocaux(locauxRepository.findById(locauxId).get());
        deratisation.setProduit(produitRepository.findById(produitId).get());


        return deratisationRepository.save(deratisation);
    }


}
