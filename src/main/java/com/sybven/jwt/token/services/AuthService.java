package com.sybven.jwt.token.services;

import com.sybven.jwt.token.dto.JwtResponseDTO;
import com.sybven.jwt.token.dto.UserDTO;
import com.sybven.jwt.token.security.JwtIo;
import com.sybven.jwt.token.util.DateUtils;
import com.sybven.jwt.token.util.GsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    
    @Autowired
    private GsonUtils gsonUtils;
    
    @Autowired
    private JwtIo jwtIo;
    
    @Autowired
    private DateUtils dateUtils;
    
    @Value("${token.jwt.token.expires-in:3600}")
    private int EXPIRES_IN;
    
    public JwtResponseDTO token(   String clientId,
                                String clienclientIdtSecret) {
        
        UserDTO user = UserDTO.builder()
                .nombre("Jorge")
                .email("jorge@gmail.com")
                .fechaNacimiento("2000-10-30")
                .build();
        
        JwtResponseDTO jwt = JwtResponseDTO.builder()
                .tokenType("Bearer")
                .accessToken(jwtIo.generateToken(user))
                .issuedAt(dateUtils.getDateMillis() + "")
                .cliedId(clientId)
                .expiresIn(EXPIRES_IN)
                .build();
    
        return jwt;
    }
    
}
