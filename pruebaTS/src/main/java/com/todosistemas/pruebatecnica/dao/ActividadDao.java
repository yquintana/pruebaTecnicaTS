package com.todosistemas.pruebatecnica.dao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.todosistemas.pruebatecnica.modelo.Actividad;
/**
 * @author yquintana
 * @date   9/07/2022
 * @description Interfaz ActividadDao encargada de realizar las operaciones en base de datos de la actividad.
 * @version 1.0
 */
@Repository
public interface ActividadDao extends CrudRepository<Actividad, Integer>{

}
