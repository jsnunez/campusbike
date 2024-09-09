package com.jsnunez.campusbike.application;

import java.util.List;
import java.util.Optional;

import com.jsnunez.campusbike.domain.Ventas;

public interface IVentas {
  Optional<Ventas> findById(Long id);
    List<Ventas> getAll();
    Ventas save(Ventas ventas);
    Ventas update(Long id,Ventas ventas);
    void deleteById(Long id); 
}
