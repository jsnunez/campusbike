package com.jsnunez.campusbike.domain;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

@Entity
@Table(name = "repuestos")
public class Repuestos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String nombre;

    
    @Column(columnDefinition = "VARCHAR(200)", nullable = false)
    private String descripcion;

    @Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
    private BigDecimal precio;

    @Column(columnDefinition = "INT", nullable = false)
    private int stock;

      @ManyToOne
    private Proveedores proveedores;

    @ManyToOne
    private Modelo modelo;

@ManyToOne
    private Marca marca;
    
}
