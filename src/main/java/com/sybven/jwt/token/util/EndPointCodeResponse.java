package com.sybven.jwt.token.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EndPointCodeResponse {
    
    /** El request fue exitoso */
    E0200("E0200", 200L, "OK"),
    /** El request fue exitoso y se agrego un registro nuevo */
    E0201("E0201", 201L, "Created"),
    /** El request fue exitoso y se modifico un registro existente */
    E0202("E0202", 202L, "Updated"),
    /** El request fue exitoso y se modifico un registro existente */
    E0203("E0203", 203L, "Deleted"),    
    /** El request esta bien formado pero la entidad no fue procesada por que existe un error en algun campo */
    E0204("E0204", 204L, "El servidor procesó correctamente la solicitud y no devuelve ningún contenido."),
    /** Indicando Datos de entrada erroneos */
    E0400("E0400", 400L, "Solicitud incorrecta"),
    /** Token invalido */
    E0401("E0401", 401L, "No autorizado"),
    /** Indicando no recursos en contrados en BD */
    E0404("E0404", 404L, "No encontrado"),
    /** Not Acceptable */
    E0406("E0406", 406L, "El servidor no es capaz de devolver los datos en ninguno de los formatos aceptados por el cliente."),
    /** Error Interno del Servidor */
    E0500("E0500", 500L, "Error Interno del Servidor"),
    /** La API externa no está disponible */
    E0600("E0600", 600L, "La API externa no está disponible"),
    /** Error desconocido */
    OTRO("OTRO", 500L, "Error desconocido");
    
    private String code;
    private Long value;
    private String status;
    
    public static EndPointCodeResponse getByCode(String code) {
        switch (code){
            case "E0200" : return EndPointCodeResponse.E0200;
            case "E0201" : return EndPointCodeResponse.E0201;
            case "E0202" : return EndPointCodeResponse.E0202;
            case "E0203" : return EndPointCodeResponse.E0203;
            case "E0204" : return EndPointCodeResponse.E0204;
            case "E0400" : return EndPointCodeResponse.E0400;
            case "E0401" : return EndPointCodeResponse.E0401;
            case "E0404" : return EndPointCodeResponse.E0404;
            case "E0406" : return EndPointCodeResponse.E0406;
            case "E0500" : return EndPointCodeResponse.E0500;
            case "E0600" : return EndPointCodeResponse.E0600;
            default : return EndPointCodeResponse.OTRO;
        }
    }
}