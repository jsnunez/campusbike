package com.jsnunez.campusbike.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
public class Bicicletas {
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    private Modelo modelo;

    @ManyToOne
    private Marca marca;

    
    @Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
    private String precio;
      
    @Column(columnDefinition = "INT", nullable = false)
    private int stock;


}
