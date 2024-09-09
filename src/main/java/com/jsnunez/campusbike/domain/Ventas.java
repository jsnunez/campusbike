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
public class Ventas {
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "DATE", nullable = false)
    private String fecha;


     @ManyToOne
    private Clientes cliente;
}
