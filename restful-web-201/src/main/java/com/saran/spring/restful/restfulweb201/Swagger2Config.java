package com.saran.spring.restful.restfulweb201;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

	  public static final Contact DEFAULT_CONTACT = new Contact("Saran", "www.learn.com", "saran@email.com");
	  public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Api Documentation - Title", "Api Description", "1.0", "urn:tos",
	          DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
	  
	@Bean
	public Docket api() {
        Set<String> consumesAndProduces = new HashSet<String>(Arrays.asList("application/json","application/xml"));
		return new Docket(DocumentationType.SWAGGER_2)
        		.apiInfo(DEFAULT_API_INFO)
				.consumes(consumesAndProduces)
        		.produces(consumesAndProduces);
        		//.pathMapping("/");
	}
	
}
