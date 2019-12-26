
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


    private String nresponsable;
    private String incerticide;
    private String nencadreur;
    private String observations;

    private String harrive;
    private String hdepart;


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
