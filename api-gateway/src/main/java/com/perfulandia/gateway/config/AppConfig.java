package com.perfulandia.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Clase configuracion de Spring para definir y personalizar Beans 
**/


@Configuration
public class AppConfig {
    
    // configuracion que declara el consumo de otros
    // microservicios externos.
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
