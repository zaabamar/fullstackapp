package com.Pfa_project.fullstackapp.exception;

public class SalleNotFoundException extends RuntimeException{
    public SalleNotFoundException(Long id){
        super("Could not find salle " + id);
    }
}
