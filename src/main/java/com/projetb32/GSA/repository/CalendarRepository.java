package com.projetb32.GSA.repository;

import java.util.List;
import java.util.Date ;
import com.projetb32.GSA.entity.Calendar;
import com.projetb32.GSA.entity.User;
import com.projetb32.GSA.entity.Company;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "calendar", collectionResourceRel = "calendar")
public interface CalendarRepository extends JpaRepository<Calendar,Long> {
 

    // @Query("SELECT co.id , co.label , c.id, c.user.id FROM Calendar c, Company co  where c.user.id = ?1 and c.date= ?2")
	// public List<Calendar> find (Long user ,  Date date  );


    @Query("SELECT   c.id, c.date ,c.company.id , c.company.label, c.user.id FROM Calendar c  where c.user.id = ?1 and c.date= ?2")
	public List<Calendar> find (Long user ,  Date date  );

}
