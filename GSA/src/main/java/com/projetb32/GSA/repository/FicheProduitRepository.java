package com.projetb32.GSA.repository;


import com.projetb32.GSA.entity.FicheProduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "ficheProduit", collectionResourceRel = "ficheProduit")
public interface FicheProduitRepository extends JpaRepository<FicheProduit,Long> {
    
}
