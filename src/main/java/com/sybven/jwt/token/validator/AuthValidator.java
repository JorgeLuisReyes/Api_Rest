package com.sybven.jwt.token.validator;

import com.sybven.jwt.token.dto.JwtRquestDTO;
import com.sybven.jwt.token.exceptions.CustomApiUnauthorizedException;
import org.springframework.stereotype.Component;

@Component
public class AuthValidator {
    
    private static final String CLIENT_CREDENTIALS = "client_credentials";
    private static final String CLIENT_ID = "admin";
    private static final String CLIENT_SECRET = "123456";
    
    public void validate(JwtRquestDTO jwtRquest) throws CustomApiUnauthorizedException {
        
        String grantType = jwtRquest.getGrantType();
        String clientId = jwtRquest.getClientId();
        String clientSecret = jwtRquest.getClientSecret();
        
        if(grantType.isEmpty() || !grantType.equals(CLIENT_CREDENTIALS)){
            throw new CustomApiUnauthorizedException("El parametro grantType es inavalido");
        }
        
        if(clientId.isEmpty() || clientSecret.isEmpty()){
            throw new CustomApiUnauthorizedException("El parametro clientId y/o clientSecret es inavalido");
        }
        
        //valida contra la base de datos clientId y clientSecret
        if( !clientId.equals(CLIENT_ID) || !clientSecret.equals(CLIENT_SECRET) ){
            throw new CustomApiUnauthorizedException("El parametro clientId y/o clientSecret no coinciden");
        }
    }
}
