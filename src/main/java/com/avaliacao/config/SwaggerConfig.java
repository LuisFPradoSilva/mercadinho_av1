package com.avaliacao.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
            .group("mercadinho")
            .pathsToMatch("/**")
            .packagesToScan("com.avaliacao.resources")
            .build();
    }

    @Bean
    public io.swagger.v3.oas.models.OpenAPI customOpenAPI() {
        return new io.swagger.v3.oas.models.OpenAPI()
            .info(new Info().title("Mercadinho")
                            .description("Mercadinho APIs")
                            .version("1.0")
                            .contact(new Contact()
                                .name("AV1")
                                .url("http://www.av1mercadinho.com.br")
                                .email("av1mercadinho@gmail.com")));
    }
}
