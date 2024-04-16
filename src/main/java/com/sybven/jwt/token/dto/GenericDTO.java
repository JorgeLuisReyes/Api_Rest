package com.sybven.jwt.token.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class GenericDTO {
    
    private String catalogue;
    private Long id;
    private String code;
    private String name;
    private String field;
    private String message;
    private String requestNum;
    private Long idVessel;
    private String type;
    private String rif;
    private String shippingAgent;
    private String centerCost;
    
}
