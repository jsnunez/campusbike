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

import com.jsnunez.campusbike.application.IVentas;
import com.jsnunez.campusbike.domain.Ventas;

@RestController
    @RequestMapping("/venta")
public class VentaController {


    @Autowired
    private IVentas ventasService;

      @GetMapping
            public ResponseEntity<List<Ventas>> list() {
                List<Ventas> ventass = ventasService.getAll();
                return new ResponseEntity<>(ventass, HttpStatus.OK);
            }
        
            @GetMapping("/{id}")
            public ResponseEntity<Ventas> show(@PathVariable Long id) {
                return ventasService.findById(id)
                        .map(ventas -> new ResponseEntity<>(ventas, HttpStatus.OK))
                        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
            }
   
            
            @PostMapping
    public ResponseEntity<Ventas> create(@RequestBody Ventas ventas) {
        Ventas createdVentas = ventasService.save(ventas);
        return new ResponseEntity<>(createdVentas, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ventas> update(@PathVariable Long id, @RequestBody Ventas ventas) {
        Ventas updatedVentas = ventasService.update(id, ventas);
        if (updatedVentas != null) {
            return new ResponseEntity<>(updatedVentas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




    @DeleteMapping ("/{id}")
    public void delete(@PathVariable Long id) {
        ventasService.deleteById(id);
    
 }


}
