package com.saran.spring.restful.restfulweb201;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.i18n.AcceptHeaderLocaleContextResolver;

@SpringBootApplication
public class RestfulWeb201Application {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWeb201Application.class, args);
	}

	@Bean
	public AcceptHeaderLocaleContextResolver localeresolver() {
		AcceptHeaderLocaleContextResolver resolver = new AcceptHeaderLocaleContextResolver();
		resolver.setDefaultLocale(Locale.US);	
		
		return resolver;
	}

}
