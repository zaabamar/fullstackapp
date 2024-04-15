package com.Pfa_project.fullstackapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

@ControllerAdvice

public class EquipementNotFoundAdvice {

    @ExceptionHandler(EquipementNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)

    Map<String, String> exceptionHandler(EquipementNotFoundException exception) {
        Map<String, String> errorMap = Map.of("error", exception.getMessage());
        return errorMap;
    }

}
