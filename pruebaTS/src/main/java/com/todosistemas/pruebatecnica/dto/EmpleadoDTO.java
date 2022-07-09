package com.todosistemas.pruebatecnica.dto;

import java.io.Serializable;
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
 * @description clase EmpleadoDTO encargada de representar el empleado en la vista
 * @version 1.0
 */
@XmlRootElement
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmpleadoDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    @NotNull
    private Integer idEmpleado;
    @NotNull
    private String nombre;
    @NotNull
    private String apellido;
    @NotNull
    private String numeroIdentificacion;
    @NotNull
    private String tipoIdentificacion;
}
