package com.jsnunez.campusbike.application;

import java.util.List;
import java.util.Optional;

import com.jsnunez.campusbike.domain.DetalleVentas;

public interface IDetalleVenta {
 Optional<DetalleVentas> findById(Long id);
    List<DetalleVentas> getAll();
    DetalleVentas save(DetalleVentas detalleventas);
    DetalleVentas update(Long id,DetalleVentas detalleventas);
    void deleteById(Long id); 
}
