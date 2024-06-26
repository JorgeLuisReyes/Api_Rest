package com.sybven.jwt.token;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins="*")
@EnableAutoConfiguration
@EnableConfigurationProperties
@SpringBootApplication
@EntityScan("com.sybven.jwt.token.model")
public class TokenApplication {
    
	public static void main(String[] args) {
            SpringApplication.run(TokenApplication.class, args);
	}

}
