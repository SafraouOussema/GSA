
package com.projetb32.GSA.repository;


import com.projetb32.GSA.entity.Fiche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "fiche", collectionResourceRel = "fiche")
public interface FicheReposity  extends JpaRepository<Fiche,Long>{


}
