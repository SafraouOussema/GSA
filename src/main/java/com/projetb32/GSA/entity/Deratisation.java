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

    private boolean acceder ;
    
    private float quantite ;

    private  long n_post;

    private boolean appats_touches;

    private boolean appats_non_touches;

    private boolean appats_abscents;

    private boolean poste_abscente;

}
