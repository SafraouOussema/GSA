
package com.projetb32.GSA.service;

import com.projetb32.GSA.entity.Fiche;
import com.projetb32.GSA.entity.Produit;
import com.projetb32.GSA.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component 
public class FicheService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private FicheReposity ficheReposity;
    @Autowired
    private CalendarRepository calendarRepository;
    @Autowired
    private UserRepository userRepository;

    public Fiche addFiche(Fiche fiche, long userId, long companyId, long calendarId) {
        fiche.setUser(userRepository.findById(userId).get());
        fiche.setCompany(companyRepository.findById(companyId).get());
        fiche.setCalendar(calendarRepository.findById(calendarId).get());

        return ficheReposity.save(fiche);
    }

    public List<Fiche> getAllFiche() {
        return ficheReposity.findAll();
    }

}
