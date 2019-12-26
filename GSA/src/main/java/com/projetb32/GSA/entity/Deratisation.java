package com.projetb32.GSA.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Deratisation implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @ManyToOne
    @JoinColumn(name = "fiche_id")
    private Fiche fiche ;


    @ManyToOne
    @JoinColumn(name = "locaux_id")
    private Locaux locaux ;


    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit ;



}
