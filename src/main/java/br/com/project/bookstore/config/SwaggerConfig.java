package br.com.project.bookstore.config;

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
                        .title("BookStore API")
                        .version("1.0.0")
                        .description("API for managing an online bookstore")
                        .contact(new Contact()
                                .name("Thiago Ramos")
                                .email("thiago.ramos@example.com")));
    }
}