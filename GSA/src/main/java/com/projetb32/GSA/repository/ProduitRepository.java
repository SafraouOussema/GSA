package com.projetb32.GSA.repository;

import com.projetb32.GSA.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "produit", collectionResourceRel = "produit")
public interface ProduitRepository extends JpaRepository<Produit,Long> {
}
