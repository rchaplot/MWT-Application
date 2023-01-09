package com.smartbee.jobdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SpringFoxConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
//                .securityContexts(Arrays.asList(actuatorSecurityContext()))
//                .securitySchemes(Arrays.asList(basicAuthScheme()));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Java Docker Application")
                .description("For job demo spring boot web")
//                .termsOfServiceUrl("localhost")
                .version("1.0")
                .license("Apache 2.0")
                .build();
    }

}
