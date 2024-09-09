package com.jsnunez.campusbike.infraestucture.repository.repositorijpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsnunez.campusbike.domain.Ventas;

public interface VentaRepository  extends JpaRepository<Ventas,Long>{

}
