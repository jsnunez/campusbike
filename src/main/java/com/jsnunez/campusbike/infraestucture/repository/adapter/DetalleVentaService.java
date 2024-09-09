package com.jsnunez.campusbike.infraestucture.repository.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsnunez.campusbike.application.IDetalleVenta;
import com.jsnunez.campusbike.domain.DetalleVentas;
import com.jsnunez.campusbike.domain.Ventas;
import com.jsnunez.campusbike.infraestucture.repository.repositorijpa.BicicletasRepository;
import com.jsnunez.campusbike.infraestucture.repository.repositorijpa.DetalleVentasRepository;
@Service
public class DetalleVentaService implements IDetalleVenta{


      @Autowired
  private DetalleVentasRepository detalleVentasRepository;


    @Override
    public Optional<DetalleVentas> findById(Long id) {
               return detalleVentasRepository.findById(id);

          }

    @Override
    public List<DetalleVentas> getAll() {
        return detalleVentasRepository.findAll();
    }

    @Override
    public DetalleVentas save(DetalleVentas detalleventas) {
        return detalleVentasRepository.save(detalleventas);
    }

    @Override
    public DetalleVentas update(Long id, DetalleVentas detalleventas) {
 
        Optional<DetalleVentas> detalleVentas = detalleVentasRepository.findById(id);
        if(detalleVentas.isPresent())
         { 
            detalleVentas.get().setBicicletas(detalleVentas.get().getBicicletas());
            detalleVentas.get().setCantidad(detalleVentas.get().getCantidad());
            detalleVentas.get().setPrecio_unitario(detalleVentas.get().getPrecio_unitario());
            detalleVentas.get().setVentas(detalleVentas.get().getVentas());
            return detalleVentasRepository.save(detalleVentas.get());
        }  else {
            throw new IllegalArgumentException("No se encontró la venta con id " + id);
        }

       
     }

    @Override
    public void deleteById(Long id) {
        detalleVentasRepository.deleteById(id);
    }

}
