package com.projetb32.GSA.repository;

import com.projetb32.GSA.entity.Desinsectisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "desinsectisation", collectionResourceRel = "desinsectisation")
public interface DesinsectisationRepository extends JpaRepository<Desinsectisation,Long> {
}
