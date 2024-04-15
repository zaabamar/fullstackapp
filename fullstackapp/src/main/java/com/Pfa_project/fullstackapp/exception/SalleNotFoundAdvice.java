package com.Pfa_project.fullstackapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice

public class SalleNotFoundAdvice {
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(SalleNotFoundException.class)


    Map<String, String> exceptionHandler(SalleNotFoundException exception) {
         Map<String, String> errorMap=new HashMap<>();
         errorMap.put("error", exception.getMessage());

         return errorMap;
    }
}
