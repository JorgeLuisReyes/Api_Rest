package com.sybven.jwt.token.controllers;

import com.sybven.jwt.token.dto.JwtRquestDTO;
import com.sybven.jwt.token.exceptions.ApiUnauthorized;
import com.sybven.jwt.token.services.AuthService;
import com.sybven.jwt.token.validator.AuthValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api")
public class AuthController {
    
    @Autowired
    private AuthService authService;
    
    @Autowired
    private AuthValidator validator;
    
    @PostMapping(path="token")
    public ResponseEntity<Object> token(@Valid @RequestBody JwtRquestDTO jwtRquest) throws ApiUnauthorized{
        
        validator.validate(jwtRquest);
        String clientId = jwtRquest.getClientId();
        String clientSecret = jwtRquest.getClientSecret();

        return ResponseEntity.ok(authService.token(clientId, clientSecret));
    }
    
}
