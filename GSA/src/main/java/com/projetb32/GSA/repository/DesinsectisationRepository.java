package com.projetb32.GSA.repository;

import com.projetb32.GSA.entity.Desinsectisation;
import com.projetb32.GSA.entity.Fiche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource(path = "desinsectisation", collectionResourceRel = "desinsectisation")
public interface DesinsectisationRepository extends JpaRepository<Desinsectisation,Long> {

    public List<Desinsectisation> findDesinsectisationByFiche(Fiche fiche);

}
