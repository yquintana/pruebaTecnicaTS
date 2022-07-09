package com.todosistemas.pruebatecnica.dao;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.todosistemas.pruebatecnica.modelo.ActividadPorEmpleado;
/**
 * @author yquintana
 * @date   9/07/2022
 * @description Interfaz ActividadPorEmpleadoDao encargada de realizar las operaciones en base de datos de la actividadPorConductor.
 * @version 1.0
 */
@Repository
public interface ActividadPorEmpleadoDao extends CrudRepository<ActividadPorEmpleado, Integer>{	
	
	public List<ActividadPorEmpleado> findAllByOrderByIdActividadPorEmpleadoDesc();	
	@Transactional
	@Query("DELETE  FROM ActividadPorEmpleado "
			+ " WHERE idActividad.idActividad =:idActividad")
	public void eliminarPorIdActividad(Integer idActividad);
	 
	@Query("SELECT ae  FROM ActividadPorEmpleado ae"
			+ " WHERE ae.idActividad.idActividad =:idActividad")
	public ActividadPorEmpleado consultarPorIdActividad(Integer idActividad);
	
}
