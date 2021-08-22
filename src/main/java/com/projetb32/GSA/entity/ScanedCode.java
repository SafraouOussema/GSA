package com.projetb32.GSA.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.Date ;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScanedCode {


    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date ;

    private String time ; 
    
 
    @ManyToOne
    @JoinColumn(name = "locaux_id")
    private Locaux locaux ;

    @ManyToOne
    @JoinColumn(name = "calendar_id")
    private Calendar calendar ;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user ;


    
}
