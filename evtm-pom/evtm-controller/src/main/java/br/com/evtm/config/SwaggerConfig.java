package br.com.evtm.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("br.com.evtm.controller"))
				.paths(PathSelectors.any()).build().apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		 return new ApiInfo(
		 "API do curso Spring Boot",
		 "Esta API é utilizada no curso de Spring Boot do prof. Nelio Alves",
		 "Versão 1.0",
		 "https://www.udemy.com/terms",
		 new Contact("Nelio Alves", "udemy.com/user/nelio-alves", "nelio.cursos@gmail.com"),
		 "Permitido uso para estudantes",
		 "https://www.udemy.com/terms",
		 Collections.emptyList() // Vendor Extensions
		);
	}

}
