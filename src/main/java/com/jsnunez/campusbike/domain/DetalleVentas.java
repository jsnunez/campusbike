package com.jsnunez.campusbike.domain;

import java.math.BigDecimal;

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
public class DetalleVentas {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     @ManyToOne
    private Ventas ventas;
    @ManyToOne
    private Bicicletas bicicletas; 

    @Column(columnDefinition = "INT", nullable = false)
    private int cantidad;

    @Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
    private BigDecimal precio_unitario;
}