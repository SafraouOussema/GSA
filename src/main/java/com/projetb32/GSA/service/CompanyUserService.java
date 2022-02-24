package com.projetb32.GSA.service;



import com.projetb32.GSA.entity.CompanyUser;
import com.projetb32.GSA.entity.Company;
import com.projetb32.GSA.entity.User;
import com.projetb32.GSA.repository.CompanyUserRepository;
import com.projetb32.GSA.repository.CompanyRepository;
import com.projetb32.GSA.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CompanyUserService {
    
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CompanyUserRepository companyUserRepository;

    public CompanyUser addStep(Long userId, long companyId) {
        CompanyUser companyUser = new CompanyUser();
        companyUser.setUser(userRepository.findById(userId).get());
        companyUser.setCompany(companyRepository.findById(companyId).get());
 
        return companyUserRepository.save(companyUser);
    }
 
 
    public List<CompanyUser> getCompanyUserByUserIdAndCompanyId(long userId,long companyId) {
        User user = userRepository.findById(userId).get();
        Company company = companyRepository.findById(companyId).get();

        return companyUserRepository.findCompanyUsersByUserAndCompany(user,company);
    }

    public List<CompanyUser> getCompanyUserByUserId(long userId) {
        User user = userRepository.findById(userId).get(); 
        return companyUserRepository.findCompanyUsersByUser(user);
    }
}
