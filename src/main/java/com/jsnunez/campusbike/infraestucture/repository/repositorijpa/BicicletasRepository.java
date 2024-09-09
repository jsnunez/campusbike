package com.jsnunez.campusbike.infraestucture.repository.repositorijpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsnunez.campusbike.domain.Bicicletas;

public interface BicicletasRepository extends JpaRepository<Bicicletas,Long> {

}
