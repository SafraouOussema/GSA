
package com.projetb32.GSA.repository;

import java.util.List;
import com.projetb32.GSA.entity.Fiche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.jpa.repository.Query;

@RepositoryRestResource(path = "fiche", collectionResourceRel = "fiche")
public interface FicheReposity  extends JpaRepository<Fiche,Long>{

    @Query("SELECT  f.id , f.nresponsable , f.incerticide , f.nencadreur , f.observations , f.harrive , f.hdepart , f.calendar.date , f.user.name , f.company.label , f.company.address   FROM Fiche f where f.calendar.id = ?1 ")
	public List<Fiche> findfichclanader (Long calanderid) ;

}
