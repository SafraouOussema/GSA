
package com.projetb32.GSA.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fiche implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;


    private String Locaux;
    private String Nresponsable;
    private String incerticide;
    private String Nencadreur;
    private String observations;

    private String Harrive;
    private String Hdepart;


    @ManyToOne
    @JoinColumn(name = "calendar_id")
    private Calendar calendar ;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user ;

    @ManyToOne
    @JoinColumn(name = "campany_id")
    private Company company ;


}
