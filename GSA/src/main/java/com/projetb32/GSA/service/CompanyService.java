package com.projetb32.GSA.service;


import com.projetb32.GSA.entity.Calendar;
import com.projetb32.GSA.repository.CompanyRepository;
import com.projetb32.GSA.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompanyService {



    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private UserRepository userRepository;
/*
    public Calendar addStep(Calendar calendar, long companyId,Long userId) {

        calendar(companyRepository.findById(companyId).get());


        return stepRepository.save(step);
    }
*/

}
