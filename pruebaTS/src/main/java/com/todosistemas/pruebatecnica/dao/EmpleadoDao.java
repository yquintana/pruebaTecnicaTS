package com.todosistemas.pruebatecnica.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.todosistemas.pruebatecnica.modelo.Empleado;

/**
 * @author yquintana
 * @date   9/07/2022
 * @description Interfaz EmpleadoDao encargada de realizar las operaciones en base de datos del empleado.
 * @version 1.0
 */
@Repository
public interface EmpleadoDao  extends CrudRepository<Empleado, Integer>{

	
	public List<Empleado>findAllByOrderByIdEmpleadoDesc();
}
