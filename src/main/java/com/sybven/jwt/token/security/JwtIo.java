package com.sybven.jwt.token.security;

import com.sybven.jwt.token.util.GsonUtils;
import io.fusionauth.jwt.Signer;
import io.fusionauth.jwt.Verifier;
import io.fusionauth.jwt.domain.JWT;
import io.fusionauth.jwt.hmac.HMACSigner;
import io.fusionauth.jwt.hmac.HMACVerifier;
import java.time.ZonedDateTime;
import java.util.TimeZone;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtIo {
    
    @Value("${token.jwt.token.secret:secret}")
    private String SECRET;
    
    @Value("${token.jwt.timezone:UTC}")
    private String TIMEZONE;
    
    @Value("${token.jwt.token.expires-in:3600}")
    private int EXPIRES_IN;
    
    @Value("${token.jwt.issuer:none}")
    private String ISSUER;
    
    
    public String generateToken(Object obj){
        
        //tranforma un objeto en un json string
        String subject = GsonUtils.serializae(obj);
        //contruir un HMAC signer usando SHA-256
        Signer signer = HMACSigner.newSHA256Signer(SECRET);
        //fecha
        TimeZone tz = TimeZone.getTimeZone(TIMEZONE);
        //fecha mas expiracion
        ZonedDateTime zdt = ZonedDateTime.now(tz.toZoneId()).plusSeconds(EXPIRES_IN);
        
        JWT jwt = new JWT()
                .setIssuer(ISSUER) //entidad que genaera el token
                .setIssuedAt(ZonedDateTime.now(tz.toZoneId())) //fecha en que se solicita el token
                .setSubject(subject) //Carga util del token
                .setExpiration(zdt); //fecha expiracion token
        
        return JWT.getEncoder().encode(jwt, signer);
    }
    
    public boolean validateToken(String encodeJwt){
        boolean result = false;
        try {
            JWT jwt = jwt(encodeJwt);
            result = jwt.isExpired();
        } catch (Exception e) {
            return true;
        }
        return result;
    }
    
    //Obtiene la informacion del payload o subject
    public String getPaylod(String encodeJwt){
        JWT jwt = jwt(encodeJwt);
        return jwt.subject;
    }
    
    private JWT jwt(String encodeJwt){
        Verifier verifier = HMACVerifier.newVerifier(SECRET);
        return JWT.getDecoder().decode(encodeJwt, verifier);
    }
      
}
