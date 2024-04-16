package com.sybven.jwt.token.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class JwtResponseDTO {
    
    //palabra clave del token
    @JsonProperty(value="token_type")
    private String tokenType;
    
    //Token
    @JsonProperty(value="access_token")
    private String accessToken;
    
    //fecha de expiracion del token
    @JsonProperty(value="expires_in")
    private int expiresIn;
    
    //fecha cuando se crea el token
    @JsonProperty(value="issued_at")
    private String issuedAt;
    
    //Nombre deel cliente
    @JsonProperty(value="clied_id")
    private String cliedId;
    
}
