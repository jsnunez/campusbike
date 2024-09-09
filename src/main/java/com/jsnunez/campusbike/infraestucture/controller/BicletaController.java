package com.jsnunez.campusbike.infraestucture.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsnunez.campusbike.application.IBicicleta;
import com.jsnunez.campusbike.domain.Bicicletas;

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



@RestController
    @RequestMapping("/bicicletas")
    public class BicletaController {

    @Autowired
    private IBicicleta bicicletasService;
        @GetMapping
            public ResponseEntity<List<Bicicletas>> list() {
                List<Bicicletas> bicicletass = bicicletasService.getAll();
                return new ResponseEntity<>(bicicletass, HttpStatus.OK);
            }
        
            @GetMapping("/{id}")
            public ResponseEntity<Bicicletas> show(@PathVariable Long id) {
                return bicicletasService.findById(id)
                        .map(bicicletas -> new ResponseEntity<>(bicicletas, HttpStatus.OK))
                        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
            }
   
            
            @PostMapping
    public ResponseEntity<Bicicletas> create(@RequestBody Bicicletas bicicletas) {
        Bicicletas createdBicicletas = bicicletasService.save(bicicletas);
        return new ResponseEntity<>(createdBicicletas, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bicicletas> update(@PathVariable Long id, @RequestBody Bicicletas bicicletas) {
        Bicicletas updatedBicicletas = bicicletasService.update(id, bicicletas);
        if (updatedBicicletas != null) {
            return new ResponseEntity<>(updatedBicicletas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




    @DeleteMapping ("/{id}")
    public void delete(@PathVariable Long id) {
        bicicletasService.deleteById(id);
    
 }

    }
