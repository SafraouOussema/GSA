package com.projetb32.GSA.controller;


import com.projetb32.GSA.entity.Calendar;
import com.projetb32.GSA.repository.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/application")
public class CalendarController  {

    @Autowired
    private CalendarRepository calendarRepository;


    @GetMapping("/calendars")
    public ResponseEntity<List<Calendar>> GetCalendar() {
        List<Calendar> listcalendar = null;
        listcalendar = calendarRepository.findAll();
        if (listcalendar.isEmpty())
            return ResponseEntity.noContent().build();

        return new ResponseEntity<>(listcalendar, HttpStatus.OK);
    }


    @PostMapping("/calendars/{userId}/{companyId}")
    public ResponseEntity<Calendar> addCalendar(@RequestBody Calendar calendar, @PathVariable long userId, @PathVariable long companyId) {
        Calendar calendarLocal = null;
        calendarLocal = calendarRepository.save(calendar);

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
