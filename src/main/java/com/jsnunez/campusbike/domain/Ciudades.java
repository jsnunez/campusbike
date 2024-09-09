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
public class Ciudades {
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String nombre;

    @ManyToOne
    private Paises paises;

}
