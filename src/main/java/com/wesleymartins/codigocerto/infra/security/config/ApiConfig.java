package com.wesleymartins.codigocerto.infra.security.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.ResourceHandlerRegistry;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "Codigo Certo", version = "v3"),
        security = @SecurityRequirement(name = "bearerAuth"),
        servers = {
                @Server(url = "https://api-codigocerto-f78e930563d7.herokuapp.com/", description = "Deploy"),
                @Server(url = "http://localhost:8080", description = "localhost")
        }
)
@SecurityScheme(name = "bearerAuth", type = SecuritySchemeType.HTTP, scheme = "bearer", bearerFormat = "JWT")
public class ApiConfig {
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springdoc-openapi-ui/")
                .resourceChain(false);
    }
}

