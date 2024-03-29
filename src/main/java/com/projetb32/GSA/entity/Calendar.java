package com.projetb32.GSA.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date ;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Calendar implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date ;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user ;

    @ManyToOne
    @JoinColumn(name = "campany_id")
    private Company company ;


}
