package com.sybven.jwt.token.controllers;

import com.sybven.jwt.token.dto.ResponseDTO;
import com.sybven.jwt.token.dto.RolDTO;
import com.sybven.jwt.token.services.RolService;
import jakarta.validation.Valid;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="rol")
public class RolController {
    
    @Autowired
    private RolService rolService;
    
    @PostMapping(path="agregar")
    public ResponseEntity<ResponseDTO> crearRol(@Valid @RequestBody RolDTO rolDTO) {
        
        ResponseDTO response = rolService.crearRol(rolDTO);
        
        Optional<Long> optionalCode = Optional.ofNullable(response.getCode());

        return optionalCode
                .map(code -> {
                    HttpStatus status = HttpStatus.valueOf(code.intValue());
                    return new ResponseEntity<>(response, status);
                })
                .orElseGet(() -> new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR));
    }
    
    @GetMapping(path="getall")
    public ResponseEntity<ResponseDTO> listarRoles() {
        
        ResponseDTO response = rolService.listarRoles();
        
        Optional<Long> optionalCode = Optional.ofNullable(response.getCode());

        return optionalCode
                .map(code -> {
                    HttpStatus status = HttpStatus.valueOf(code.intValue());
                    return new ResponseEntity<>(response, status);
                })
                .orElseGet(() -> new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR));
    }
    
    @GetMapping(path="getid/{id}")
    public ResponseEntity<ResponseDTO> buscarPorId(@PathVariable("id") Long id) {
        
        ResponseDTO response = rolService.buscarPorId(id);
        
        Optional<Long> optionalCode = Optional.ofNullable(response.getCode());

        return optionalCode
                .map(code -> {
                    HttpStatus status = HttpStatus.valueOf(code.intValue());
                    return new ResponseEntity<>(response, status);
                })
                .orElseGet(() -> new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR));
    }
    
    @PutMapping(path="modificar")
    public ResponseEntity<ResponseDTO> actualizarRol(@Valid @RequestBody RolDTO rolDTO) {
        
        ResponseDTO response = rolService.actualizarRol(rolDTO);
        
        Optional<Long> optionalCode = Optional.ofNullable(response.getCode());

        return optionalCode
                .map(code -> {
                    HttpStatus status = HttpStatus.valueOf(code.intValue());
                    return new ResponseEntity<>(response, status);
                })
                .orElseGet(() -> new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR));
    }
    
    @DeleteMapping(path="eliminar")
    public ResponseEntity<ResponseDTO> eliminarRolPorId(@RequestBody RolDTO rolDTO) {
        
        ResponseDTO response = rolService.eliminarRolPorId(rolDTO);
        
        Optional<Long> optionalCode = Optional.ofNullable(response.getCode());

        return optionalCode
                .map(code -> {
                    HttpStatus status = HttpStatus.valueOf(code.intValue());
                    return new ResponseEntity<>(response, status);
                })
                .orElseGet(() -> new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR));
    }
    
}
