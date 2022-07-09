package com.todosistemas.pruebatecnica.controlador;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.todosistemas.pruebatecnica.dto.ActividadDTO;
import com.todosistemas.pruebatecnica.servicio.IActividadServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
/**
 * @author yquintana
 * @date   9/07/2022
 * @description clase ActividadControlador encargada de manejar las operaciones de  las actividades.
 * @version 1.0
 */
@RestController
@Tag(description = "Controlador donde se agrega las operaciones de las actividades", 
name = "Controlador de Actividad")
public class ActividadControlador {
	@Autowired
	private IActividadServicio servicioActividad;
	
	@Operation(summary = "Crear Actividad", 
            description = "Se crea la actividad con el empleado asignado")
    @ApiResponses(value = { 
            @ApiResponse(responseCode = "200", 
                    description = "Consumo correcto"),
            @ApiResponse(responseCode = "400", 
                    description = "Error en los valores de entrada"),
            @ApiResponse(responseCode = "404", 
                    description = "Operacion no encontrada") ,
            @ApiResponse(responseCode = "500", 
            description = "Ha ocurrido un error inesperado") 
            })
    @PostMapping("/crearActividad")
    public ActividadDTO crearActividad(@RequestBody(required = true) @Valid ActividadDTO  actividadDTO ) throws Exception{
	return servicioActividad.crearActividad(actividadDTO);
	}
	@Operation(summary = "Actualizar Actividad", 
            description = "Se crea actualiza la actividad con el empleado asignado")
    @ApiResponses(value = { 
            @ApiResponse(responseCode = "200", 
                    description = "Consumo correcto"),
            @ApiResponse(responseCode = "400", 
                    description = "Error en los valores de entrada" ),
            @ApiResponse(responseCode = "404", 
                    description = "Operacion no encontrada"),
            @ApiResponse(responseCode = "500", 
            description = "Ha ocurrido un error inesperado")
            }) 
    @PutMapping("/actualizarActividad/{idActividad}")
    public ActividadDTO actualizarActividad(@RequestBody(required = true) @Valid ActividadDTO  actividadDTO,@PathVariable Integer idActividad ) throws Exception{
	return servicioActividad.actualizarActividad(actividadDTO,idActividad);
  }
	
	
	@Operation(summary = "Listar Actividad", 
            description = "Se listas todas las actividades sin filtro")
    @ApiResponses(value = { 
            @ApiResponse(responseCode = "200", 
                    description = "Consumo correcto"),
            @ApiResponse(responseCode = "400", 
                    description = "Error en los valores de entrada" ),
            @ApiResponse(responseCode = "404", 
                    description = "Operacion no encontrada"),
            @ApiResponse(responseCode = "500", 
            description = "Ha ocurrido un error inesperado")
            }) 
    @GetMapping("/listarActividades")
    public List<ActividadDTO> listarActividades() throws Exception{
	return servicioActividad.listarActividades();
  }
	
	
	@Operation(summary = "Eliminar Actividad", 
            description = "Se elimina la actividad por el id")
    @ApiResponses(value = { 
            @ApiResponse(responseCode = "200", 
                    description = "Consumo correcto"),
            @ApiResponse(responseCode = "400", 
                    description = "Error en los valores de entrada" ),
            @ApiResponse(responseCode = "404", 
                    description = "Operacion no encontrada"),
            @ApiResponse(responseCode = "500", 
            description = "Ha ocurrido un error inesperado")
            }) 
    @DeleteMapping("/eliminarActividad/{idActividad}")
    public void eliminarActividad(@PathVariable Integer idActividad ) throws Exception{
	 servicioActividad.eliminarActividad(idActividad);  
	}

}
