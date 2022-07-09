package com.todosistemas.pruebatecnica;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.todosistemas.pruebatecnica.comunes.GeneralCTE;
/**
 * @author yquintana
 * @date   9/07/2022
 * @description clase PruebaTsApplication encargada de inicar la aplicacion
 * @version 1.0
 */
@SpringBootApplication
@EntityScan({"com.todosistemas.pruebatecnica.modelo"})
public class PruebaTsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaTsApplication.class, args);
	}

	@PostConstruct
    public void init(){
	System.setProperty("user.timezone", GeneralCTE.ZONA_HORARIA_BOGOTA);
    TimeZone.setDefault(TimeZone.getTimeZone(GeneralCTE.ZONA_HORARIA_BOGOTA));  
    }
}
