package com.perritotoystore.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Perrito Toy Store API")
                        .version("1.0.0")
                        .description("API para gerenciamento da Perrito Toy Store")
                        .contact(new Contact()
                                .name("Perrito")
                        ));
    }
}
