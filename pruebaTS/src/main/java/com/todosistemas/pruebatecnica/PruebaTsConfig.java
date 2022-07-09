package com.todosistemas.pruebatecnica;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
/**
 * @author yquintana
 * @date   9/07/2022
 * @description clase PruebaTsConfig encargada de las configuraciones de spring
 * @version 1.0
 */
@Configuration
public class PruebaTsConfig {	
	
	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*")
                .allowedMethods("GET", "POST","PUT", "DELETE");
            }
        };
    }
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}	
	
	
	 @Bean
	 public OpenAPI openApi() {
	        return new OpenAPI()
	                .info(new Info()
	                        .title("Prueba Tecnica Todo sistemas")
	                        .description("Prueba Tecnica de Yerson Quintana")
	                        .version("v1.0")
	                        .contact(new Contact()
	                                .name("Yerson Quintana")
	                                .url("https://www.todosistemassti.co")
	                                .email("yersonquintana@gmail.com"))
	                );
	    }
	
}
