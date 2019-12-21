package com.projetb32.GSA.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FicheProduitPk implements Serializable {

    @ManyToOne(optional = false, fetch = FetchType.EAGER , cascade= CascadeType.ALL)
    @JoinColumn(name = "produit_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Produit produit ;


    @ManyToOne(optional = false, fetch = FetchType.EAGER , cascade= CascadeType.ALL)
    @JoinColumn(name = "fiche_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Fiche fiche;



}
