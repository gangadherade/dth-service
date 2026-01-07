package com.dth.config;

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
                        .title("DTH Data Service API")
                        .version("1.0.0")
                        .description("REST API for managing DTH (Data Transfer Hub) and Numpy data")
                        .contact(new Contact()
                                .name("DTH Team")
                                .email("dth-team@example.com")));
    }
}
