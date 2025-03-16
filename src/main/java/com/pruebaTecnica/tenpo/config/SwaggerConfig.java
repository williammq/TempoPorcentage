package com.pruebaTecnica.tenpo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Tenpo")
                        .version("1.0")
                        .description("Documentación de la API Tenpo")
                        .contact(new Contact()
                                .name("Soporte Tenpo")
                                .email("soporte@tenpo.com")
                                .url("https://tenpo.com")
                        )
                );
    }
}