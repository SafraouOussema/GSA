package com.projetb32.GSA.service;

import com.projetb32.GSA.entity.Company;
import com.projetb32.GSA.entity.Locaux;
import com.projetb32.GSA.repository.CompanyRepository;
import com.projetb32.GSA.repository.LocauxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class LocauxService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private LocauxRepository locauxRepository;

    public Locaux addlocaux(Locaux locaux, long companyId) {
        locaux.setCompany(companyRepository.findById(companyId).get());


        return locauxRepository.save(locaux);
    }

    public List<Locaux> getLocauxByCompany(long companyId) {
        Company company = companyRepository.findById(companyId).get();
        return locauxRepository.findLocauxByCompany(company);
    }

}
