package com.aura.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {

        final String nomeEsquemaDeSeguranca = "bearerAuth";

        return new OpenAPI()
                .info(new Info()
                        .title("Aura Project API")
                        .version("1.0")
                        .description("Descrição da API do Aura Project.")
                ).addSecurityItem(
                        new SecurityRequirement()
                                .addList(nomeEsquemaDeSeguranca)
                ).components(
                        new Components()
                                .addSecuritySchemes(
                                        nomeEsquemaDeSeguranca,
                                        new SecurityScheme()
                                                .name(nomeEsquemaDeSeguranca)
                                                .type(SecurityScheme.Type.HTTP)
                                                .scheme("bearer")
                                                .bearerFormat("JWT")
                                )
                );
    }
}
