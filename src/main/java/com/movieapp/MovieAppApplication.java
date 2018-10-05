package com.movieapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

//AL MOMENTO DEL DESPLIEGUE AGREGO..
//extends SpringBootServletInitializer

@SpringBootApplication
public class MovieAppApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MovieAppApplication.class, args);
	}
	
	//AL MOMENTO DEL DESPLIEGUE SOBREESCRIBO ESTE METODO, SINO DEJARLO COMENTADO
		@Override
		protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
			return application.sources(MovieAppApplication.class);
		}
}
