package com.Pfa_project.fullstackapp.exception;

public class EquipementNotFoundException extends RuntimeException{
    public EquipementNotFoundException(Long id){
        super("Could not find equipement " + id);
    }
}
