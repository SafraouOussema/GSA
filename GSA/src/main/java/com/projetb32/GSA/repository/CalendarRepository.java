package com.projetb32.GSA.repository;

import com.projetb32.GSA.entity.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "calendar", collectionResourceRel = "calendar")
public interface CalendarRepository extends JpaRepository<Calendar,Long> {

}
