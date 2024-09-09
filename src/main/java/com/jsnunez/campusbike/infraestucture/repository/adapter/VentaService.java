package com.jsnunez.campusbike.infraestucture.repository.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsnunez.campusbike.application.IVentas;
import com.jsnunez.campusbike.domain.Ventas;
import com.jsnunez.campusbike.infraestucture.repository.repositorijpa.VentaRepository;



@Service
public class VentaService implements IVentas{

 @Autowired
  private VentaRepository ventaRepository;


    @Override
    public Optional<Ventas> findById(Long id) {
        return ventaRepository.findById(id);
    }

    @Override
    public List<Ventas> getAll() {
        return ventaRepository.findAll();
    }

    @Override
    public Ventas save(Ventas ventas) {
        return ventaRepository.save(ventas);
    }

    @Override
    public Ventas update(Long id, Ventas ventas) {
        Optional<Ventas> optional = ventaRepository.findById(id);
        if (optional.isPresent()) {
            Ventas ventasToUpdate = optional.get();

            ventasToUpdate.setCliente(ventas.getCliente());
            ventasToUpdate.setFecha(ventas.getFecha());
            return ventaRepository.save(ventasToUpdate);
        } else {
            throw new IllegalArgumentException("No se encontró la venta con id " + id);
        }
    
    
    
    }

    @Override
    public void deleteById(Long id) {
       ventaRepository.deleteById(id);
     }


}
