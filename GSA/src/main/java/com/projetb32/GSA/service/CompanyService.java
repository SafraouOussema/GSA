package com.projetb32.GSA.service;


import com.projetb32.GSA.entity.Calendar;
import com.projetb32.GSA.repository.CalendarRepository;
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
    @Autowired
    private CalendarRepository calendarRepository;

    public Calendar addStep(Calendar calendar,Long userId, long companyId) {
        calendar.setUser(userRepository.findById(userId).get());
        calendar.setCompany(companyRepository.findById(companyId).get());


        return calendarRepository.save(calendar);
    }


}
