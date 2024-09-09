package com.jsnunez.campusbike.application;

import java.util.List;
import java.util.Optional;

import com.jsnunez.campusbike.domain.Bicicletas;

public interface IBicicleta {

  Optional<Bicicletas> findById(Long id);
    List<Bicicletas> getAll();
    Bicicletas save(Bicicletas bicicletas);
    Bicicletas update(Long id,Bicicletas bicicletas);
    void deleteById(Long id); 
}
