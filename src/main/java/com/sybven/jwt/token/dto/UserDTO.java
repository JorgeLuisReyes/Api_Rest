package com.sybven.jwt.token.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    
    @JsonProperty(value="idUser")
    private Long idUser;
    
    @JsonProperty(value="idRol")
    private Long idRol;
    
    @JsonProperty(value="nombre")
    @NotBlank(message = "nombre es obligatorio")
    private String nombre;
    
    @JsonProperty(value="email")
    @NotBlank(message = "email es obligatorio")
    private String email;
    
    @JsonProperty(value="fechaNacimiento")
    @NotBlank(message = "fechaNacimiento es obligatorio")
    private String fechaNacimiento;
   
}
