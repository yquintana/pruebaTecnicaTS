package com.todosistemas.pruebatecnica.servicio;

import java.util.List;
import com.todosistemas.pruebatecnica.dto.EmpleadoDTO;

public interface IEmpleadoServicio {
	/**
	 * @author yquintana
	 * @date   9/07/2022
	 * @description metodo encargado de traer todos los empleados
	 * @version 1.0
	 * @return retorna la lista de los empleados sin discriminacion.
	 */
	public List<EmpleadoDTO> listarEmpleados();
}
