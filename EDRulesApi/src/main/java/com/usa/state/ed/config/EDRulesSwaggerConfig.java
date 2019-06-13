package com.usa.state.ed.config;

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

/**
 * This class is used to configure the swagger
 * @author shrikant
 *
 */
@Configuration
@EnableSwagger2
public class EDRulesSwaggerConfig {
	
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.usa.state.ed.controller"))
                .paths(PathSelectors.any())
                .build();
    }
 
    private ApiInfo getApiInfo() {
        Contact contact = new Contact("Shrikant Misal", "http://www.uhip.com", "shri@gmail.com");
        return new ApiInfoBuilder()
                .title("Rules Api for checking Eligibility....")
                .description("Give the plan name and check weather the person is eligible for plan or not")
                .version("1.0.0")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .contact(contact)
                .build();
    }
}
