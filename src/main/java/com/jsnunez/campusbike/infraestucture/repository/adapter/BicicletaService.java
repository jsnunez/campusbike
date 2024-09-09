package com.jsnunez.campusbike.infraestucture.repository.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsnunez.campusbike.application.IBicicleta;
import com.jsnunez.campusbike.domain.Bicicletas;
import com.jsnunez.campusbike.infraestucture.repository.repositorijpa.BicicletasRepository;

@Service
public class BicicletaService implements IBicicleta{

  @Autowired
  private BicicletasRepository BicicletasRepository;




    @Override
    public Optional<Bicicletas> findById(Long id) {
        return BicicletasRepository.findById(id);
    }



    @Override
    public List<Bicicletas> getAll() {
       return BicicletasRepository.findAll();
    }



    @Override
    public Bicicletas save(Bicicletas bicicletas) {
       return BicicletasRepository.save(bicicletas);
    }



    @Override
    public Bicicletas update(Long id, Bicicletas bicicletas) {
       
        Optional<Bicicletas> bicicletaOptional = BicicletasRepository.findById(id);

        if (bicicletaOptional.isPresent()) {
            Bicicletas bicicletaToUpdate = bicicletaOptional.get();
            bicicletaToUpdate.setModelo(bicicletas.getModelo());
            bicicletaToUpdate.setMarca(bicicletas.getMarca());
            bicicletaToUpdate.setPrecio(bicicletas.getPrecio());
            return BicicletasRepository.save(bicicletaToUpdate);
        }
        return null;
    }



    @Override
    public void deleteById(Long id) {
        BicicletasRepository.deleteById(id);
    }

   

}
