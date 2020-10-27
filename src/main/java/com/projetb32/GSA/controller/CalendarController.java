package com.projetb32.GSA.controller;


import com.projetb32.GSA.entity.Calendar;
import com.projetb32.GSA.repository.CalendarRepository;
import com.projetb32.GSA.repository.CompanyRepository;
import com.projetb32.GSA.repository.UserRepository;
import com.projetb32.GSA.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Date ;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/application")
public class CalendarController  {

    @Autowired
    private CalendarRepository calendarRepository;


    @Autowired
    private CompanyRepository companyRepository;



    @Autowired
    private CompanyService companyService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/calendars")
    public ResponseEntity<List<Calendar>> GetCalendar() {
        List<Calendar> listcalendar = null;
        listcalendar = calendarRepository.findAll();
        if (listcalendar.isEmpty())
            return ResponseEntity.noContent().build();

        return new ResponseEntity<>(listcalendar, HttpStatus.OK);
    }

	@GetMapping("/calendarsdate/{idusers}/{date}")
	public ResponseEntity<List<Calendar>>  Getcalandarbydateanduser(@PathVariable Long idusers , @PathVariable Date date) 
	{
        List<Calendar> locausList;
        locausList = calendarRepository.find(idusers,date);		
        return new ResponseEntity<>(locausList, HttpStatus.OK);
	}
   
    @PostMapping("/calendars/{userId}/{companyId}")
    public ResponseEntity<Calendar> addCalendar(@RequestBody Calendar calendar, @PathVariable long userId, @PathVariable long companyId) {
        Calendar calendarLocal = companyService.addStep(calendar, userId,companyId);

        if (calendarLocal == null)
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(calendarLocal, HttpStatus.OK);

    }


    @DeleteMapping("/calendars/{calendarId}")
    public ResponseEntity<Calendar> deleteCalendar(@PathVariable long calendarId) {
        calendarRepository.deleteById(calendarId);
        return ResponseEntity.accepted().build();
    }


}
