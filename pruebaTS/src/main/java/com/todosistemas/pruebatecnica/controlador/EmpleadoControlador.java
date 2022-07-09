package com.todosistemas.pruebatecnica.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.todosistemas.pruebatecnica.dto.EmpleadoDTO;
import com.todosistemas.pruebatecnica.servicio.IEmpleadoServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
/**
 * @author yquintana
 * @date   9/07/2022
 * @description clase EmpleadoControlador encargada de realizar las operaciones del empleado
 * @version 1.0
 */
@RestController
@Tag(description = "Controlador donde se agrega las operaciones del empleado", 
name = "Controlador de Empleado")
public class EmpleadoControlador {
	@Autowired
	private IEmpleadoServicio empleadoServicio;
	
       @Operation(summary = "Consulta de empleado", 
	            description = "Se consulta lista de empleados por nombre")
	    @ApiResponses(value = { 
	            @ApiResponse(responseCode = "200", 
	                    description = "Consumo correcto"),
	            @ApiResponse(responseCode = "400", 
	                    description = "Error en los valores de entrada"
	     ),
	            @ApiResponse(responseCode = "404", 
	                    description = "Operacion no encontrada"
	     ) }) 
	    @GetMapping("/consultarEmpleados")
	    public List<EmpleadoDTO> consultaEmpleado() {
		 return empleadoServicio.listarEmpleados();
	 }

}
