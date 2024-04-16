package com.sybven.jwt.token.security;

import com.sybven.jwt.token.exceptions.ApiUnauthorized;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.ContentCachingResponseWrapper;

@Component
public class InterceptorJwtIo implements HandlerInterceptor {

    @Value("${token.jwt.token.auth.path}")
    private String AUTH_PATH;
    
    @Value("#{'${token.jwt.excluded.path}'.split(',')}")
    private List<String> excluded;
    
    @Autowired
    private JwtIo jwtIo;
    
    @Override
    public boolean preHandle(   HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler) throws Exception {
        
        boolean validate = false;
        String url = request.getRequestURI();
        String message = "";
        
        //Da permiso a la ruta de generar token y a las rutas excluidas
        if(url.equals(AUTH_PATH) || excluded(url)){
            validate = true;
        }
        
        if(     !validate &&
                request.getHeader("Authorization") != null &&
                !request.getHeader("Authorization").isEmpty()
                ){
            String token = request.getHeader("Authorization").replace("Bearer ","");
            validate = !jwtIo.validateToken(token);

        }

        if (!validate) {
            //response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write("{\n"
                    + "    \"status\": 401,\n"
                    + "    \"errors\": [\n"
                    + "        \"Token invalido\"\n"
                    + "    ]\n"
                    + "}");
            response.flushBuffer();
        }
        

        
        return validate;
    }
    
    private boolean excluded(String path){
        boolean result = false;
        for(String exc : excluded){
            if(!exc.equals("#") && exc.equals(path)){
               result = true; 
            }
        }
        return result;
    }
    
}
