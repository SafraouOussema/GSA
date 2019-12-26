package com.projetb32.GSA.repository;

import com.projetb32.GSA.entity.Company;
import com.projetb32.GSA.entity.Locaux;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(path = "locaux", collectionResourceRel = "locaux")
public interface LocauxRepository extends JpaRepository<Locaux,Long> {

    public List<Locaux> findLocauxByCompany(Company company);


}
