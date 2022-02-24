package com.projetb32.GSA.repository;


import java.util.List;
import java.util.Date ;
import com.projetb32.GSA.entity.CompanyUser;
import com.projetb32.GSA.entity.User;
import com.projetb32.GSA.entity.Company;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "companyUser", collectionResourceRel = "companyUser")
public interface CompanyUserRepository extends JpaRepository<CompanyUser,Long> {
    
    public List<CompanyUser> findCompanyUsersByUserAndCompany(User user,Company company);

    public List<CompanyUser> findCompanyUsersByUser(User user);

}
 