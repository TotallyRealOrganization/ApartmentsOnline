package com.apartmentsonline.SwaggerUI;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

// documentation here https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
// only way its working so far => localhost:8080/swagger-ui.html then enter localhost:8080/api for when prompted with
// base url

@Configuration
@EnableSwagger2
@EnableWebMvc
public class SpringFoxConfig {

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "ApartmentsOnline REST API",
                "A website to find apartments based on your needs and preferences.",
                "API TOS",
                "Terms of service",
                new Contact("Project2", "www.ApartmentsOnline", "revatureProject2"),
                "License of API",
                "API license URL",
                Collections.emptyList());
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .host("http://localhost:8080")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}

