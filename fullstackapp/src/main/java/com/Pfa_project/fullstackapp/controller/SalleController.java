package com.Pfa_project.fullstackapp.controller;

import com.Pfa_project.fullstackapp.exception.EquipementNotFoundException;
import com.Pfa_project.fullstackapp.exception.SalleNotFoundException;
import com.Pfa_project.fullstackapp.model.Salle;
import com.Pfa_project.fullstackapp.repsitory.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3001")

public class SalleController {
    @Autowired
    private SalleRepository salleRepository;

@PostMapping("/salle")
    Salle newSalle(@RequestBody Salle newSalle){
        return salleRepository.save(newSalle);
    }
    @GetMapping("/salles")
    List<Salle> all(){
        return salleRepository.findAll();
    }
    @GetMapping("/salles/{id}")
    Salle GetSalleById(@PathVariable Long id){
        return salleRepository.findById(id)
                .orElseThrow(() -> new SalleNotFoundException(id));
    }
    @PutMapping("/salles/{id}")
    Salle updateSalle(@RequestBody Salle newSalle, @PathVariable Long id){
        return salleRepository.findById(id)
                .map(salle -> {
                    salle.setNom(newSalle.getNom());
                    salle.setStatus(newSalle.getStatus());
                    salle.setCapacite(newSalle.getCapacite());
                    return salleRepository.save(salle);
                })
                .orElseThrow(()->new EquipementNotFoundException(id));
    }
    @DeleteMapping("/salles/{id}")
    String deleteSalle(@PathVariable Long id){
        if (!salleRepository.existsById(id)){
            throw new SalleNotFoundException(id);
        }
        salleRepository.deleteById(id);
        return "Salle deleted";
    }
}
