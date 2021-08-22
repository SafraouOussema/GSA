package com.projetb32.GSA.repository;


import java.util.List;
import com.projetb32.GSA.entity.Calendar; 
import com.projetb32.GSA.entity.ScanedCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.jpa.repository.Query;


@RepositoryRestResource(path = "scanedCode", collectionResourceRel = "scanedCode")
public interface ScanedCodeRepository    extends JpaRepository<ScanedCode,Long>{
    
    // @Query("SELECT f.id   FROM ScanedCode f where f.calendar.id = ?1 ")
	// public List<ScanedCode> findScanedCode (Long calanderid ) ;

    public List<ScanedCode> findDesinsectisationByCalendar(Calendar calendar) ;

}
 