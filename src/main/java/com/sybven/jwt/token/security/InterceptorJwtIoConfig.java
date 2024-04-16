package com.sybven.jwt.token.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class InterceptorJwtIoConfig implements WebMvcConfigurer {
    
    @Value("${token.jwt.security.enabled:false}")
    private boolean securityEnabled;
    
    @Autowired
    private InterceptorJwtIo interceptorJwtIo;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        if(securityEnabled){
            registry.addInterceptor(interceptorJwtIo);
        }
    }
     
}
