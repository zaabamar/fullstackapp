package com.Pfa_project.fullstackapp.controller;

import com.Pfa_project.fullstackapp.exception.EquipementNotFoundException;
import com.Pfa_project.fullstackapp.model.Equipement;
import com.Pfa_project.fullstackapp.repsitory.EquipementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3001")
public class EquipementController {
    @Autowired
    private EquipementRepository equipementRepository;

    @PostMapping("/equipement")
    Equipement newEquipement(@RequestBody Equipement newEquipement){
        return equipementRepository.save(newEquipement);
    }
    @GetMapping("/equipements")
    List<Equipement> all(){
        return equipementRepository.findAll();
    }
    @GetMapping("/equipements/{id}")
    Equipement GetEquipementById(@PathVariable Long id){
        return equipementRepository.findById(id)
                .orElseThrow(() -> new EquipementNotFoundException(id));
    }
    @PutMapping("/equipements/{id}")
    Equipement updateEquipement(@RequestBody Equipement newEquipement, @PathVariable Long id){
        return equipementRepository.findById(id)
                .map(equipement -> {
                    equipement.setType(newEquipement.getType());
                    equipement.setStatus(newEquipement.getStatus());
                    return equipementRepository.save(equipement);
                })
                .orElseThrow(()->new EquipementNotFoundException(id));
    }
    @DeleteMapping("/equipements/{id}")
    String deleteEquipement(@PathVariable Long id){
        if (!equipementRepository.existsById(id)){
            throw new EquipementNotFoundException(id);
        }
        equipementRepository.deleteById(id);
        return "Equipement deleted";
    }

}
