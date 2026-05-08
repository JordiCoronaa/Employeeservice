package com.example.employeeservice.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI employeeOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("Employee Service API")
                        .description("REST API for employee management")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Jordi Corona")
                                .email("jordi@email.com")))
                .externalDocs(new ExternalDocumentation()
                        .description("Project Documentation"));
    }
}