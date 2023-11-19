package com.rafael_dev.ecomerce.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Ecommerce API -------")
                        .version("0.11")
                        .description("Ecommerce app Spring Boot 3 with Swagger")
                        .termsOfService("https://swagger.io/terms/")
                        .license(new License().name("Apache 2.0").url("https://springdoc.org")));

    }
    @Bean
    public WebMvcConfigurer corsConfigure(){
        return new WebMvcConfigurer() {
            public void addCornsMapping(CorsRegistry registry){
                registry.addMapping("/**" )
                        .allowedOrigins("*")
                        .allowedMethods("GET", "PUT", "POST", "DELETE", "OPTIONS");
            }
        };
    }
}

