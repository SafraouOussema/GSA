package com.projetb32.GSA.repository;

import com.projetb32.GSA.entity.Deratisation;
import com.projetb32.GSA.entity.Fiche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "deratisation", collectionResourceRel = "deratisation")
public interface DeratisationRepository extends JpaRepository<Deratisation,Long> {

    public List<Deratisation> findDeratisationByFiche(Fiche fiche);


}
