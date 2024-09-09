package com.jsnunez.campusbike.infraestucture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jsnunez.campusbike.application.IDetalleVenta;
import com.jsnunez.campusbike.domain.DetalleVentas;

@RestController
@RequestMapping("/detalleventas")
public class DetalleVentaController {

@Autowired
private IDetalleVenta detalleService;

    @GetMapping
    public ResponseEntity<List<DetalleVentas>> list() {
        List<DetalleVentas> detalleVentas = detalleService.getAll();
        return new ResponseEntity<>(detalleVentas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleVentas> show(@PathVariable Long id) {
        return detalleService.findById(id)
                .map(detalleVentas -> new ResponseEntity<>(detalleVentas, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<DetalleVentas> create(@RequestBody DetalleVentas detalleVentas) {
        DetalleVentas createdDetalleVenta = detalleService.save(detalleVentas);
        return new ResponseEntity<>(createdDetalleVenta, HttpStatus.CREATED);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<DetalleVentas> update(@PathVariable Long id, @RequestBody DetalleVentas detalleVentas) {
        DetalleVentas updatedDetalles = detalleService.update(id, detalleVentas);
        if (updatedDetalles != null) {
            return new ResponseEntity<>(updatedDetalles, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    @DeleteMapping ("/{id}")
    public void delete(@PathVariable Long id) {
        detalleService.deleteById(id);
    
 }
}

 
