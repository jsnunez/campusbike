package com.jsnunez.campusbike.domain;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Modelo {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String nombre;
    
    @Column(columnDefinition = "VARCHAR(200)", nullable = false)
    private String descripcion;

    @OneToMany (mappedBy = "modelo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Bicicletas> bicicletas;
}
