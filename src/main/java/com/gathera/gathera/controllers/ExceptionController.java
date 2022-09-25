package com.gathera.gathera.controllers;

import com.gathera.gathera.exceptions.ModelNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = ModelNotFoundException.class)
    public ResponseEntity<Object> exception(ModelNotFoundException exception) {
        HashMap<String, String> map = new HashMap<>();
        map.put("error", exception.getMessage());
        map.put("status", "404");
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }
}
