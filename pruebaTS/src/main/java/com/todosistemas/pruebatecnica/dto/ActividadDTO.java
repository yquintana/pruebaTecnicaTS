package com.todosistemas.pruebatecnica.dto;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author yquintana
 * @date   9/07/2022
 * @description clase ActividadDTO encargada de representar la actividad en la vista
 * @version 1.0
 */
@XmlRootElement
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActividadDTO implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	private Integer idActividad;
	@NotNull
	private String nombre;
	@NotNull
	private String descripcion;	
	private String estado;	
	@NotNull
	private Date fechaEjecucion;
	@NotNull
	private Integer idIntEmpleado;
	private String nombreEmpleado;
	//periorodos
    private Integer diasDiferencia;
    private Integer mesesDiferencia;
    private Integer aniosDiferencia;
}
