package com.projetb32.GSA.service;


import com.projetb32.GSA.entity.Calendar;
import com.projetb32.GSA.entity.Company;
import com.projetb32.GSA.entity.User;
import com.projetb32.GSA.repository.CalendarRepository;
import com.projetb32.GSA.repository.CompanyRepository;
import com.projetb32.GSA.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
    public Optional<Company> getCompanyById(Long id) {
        return companyRepository.findById(id);
    }
 
    public List<Calendar> getCalendarByUser(long userId) {
        User user = userRepository.findById(userId).get();
        return calendarRepository.findCalendarsByUser(user);
    }

    public List<Calendar> getCalendarByCompany(long companyId) {
        Company company = companyRepository.findById(companyId).get();
        return calendarRepository.findCalendarsByCompany(company);
    }

}
