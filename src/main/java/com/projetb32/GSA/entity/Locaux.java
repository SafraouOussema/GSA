package com.projetb32.GSA.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity @Data
@AllArgsConstructor
@NoArgsConstructor
public class Locaux implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String name ;


    @ManyToOne
    @JoinColumn(name = "campany_id")
    private Company company ;


}
