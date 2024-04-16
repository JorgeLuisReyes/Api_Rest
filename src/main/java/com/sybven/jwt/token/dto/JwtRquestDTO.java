package com.sybven.jwt.token.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
public class JwtRquestDTO {
    
    @JsonProperty(value="grant_type")
    @NotBlank(message = "grantType es obligatorio")
    @Size(min = 2, max = 50, message = "grantType debe tener entre 2 y 50 caracteres")
    private String grantType;
    
    @JsonProperty(value="client_id")
    @NotBlank(message = "clientId es obligatorio")
    @Size(min = 2, max = 50, message = "clientId debe tener entre 2 y 50 caracteres")
    private String clientId;
    
    @JsonProperty(value="client_secret")
    @NotBlank(message = "clientSecret es obligatorio")
    @Size(min = 2, max = 50, message = "clientSecret debe tener entre 2 y 50 caracteres")
    private String clientSecret;
    
}
