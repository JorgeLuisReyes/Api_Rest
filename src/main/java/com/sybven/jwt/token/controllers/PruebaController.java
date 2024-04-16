package com.sybven.jwt.token.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="prueba")
public class PruebaController {
    
    @GetMapping(path="endpoint")
    public ResponseEntity<Object> prueba(){
        return ResponseEntity.ok("Prueba de endpoint restful api");
    }
    
}
