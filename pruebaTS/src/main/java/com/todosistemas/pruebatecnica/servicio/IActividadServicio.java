package com.todosistemas.pruebatecnica.servicio;

import java.util.List;

import com.todosistemas.pruebatecnica.dto.ActividadDTO;

public interface IActividadServicio {
    /**
     * 
     * @author yquintana
     * @date   9/07/2022
     * @description metodo encargado de la creacion de la actividad
     * @version 1.0
     * @param actividad objeto que representa la actividad
     * @return retorna la actividad con el id
     */
	public ActividadDTO crearActividad(ActividadDTO actividad) throws Exception;
	/**
	 * @author yquintana
	 * @date   9/07/2022
	 * @description metodo encargado de actualizar la actividad
	 * @version 1.0
	 * @param actividad objetos con los valores a actualizar
	 * @param idActividad actividad previamente insertada
	 * @return retorna los valores actualizados 
	 * @throws Exception
	 */
	public ActividadDTO actualizarActividad(ActividadDTO actividad,Integer idActividad) throws Exception;
	/**
	 * @author yquintana
	 * @date   9/07/2022
	 * @description metodo encargado de eliminar la actividad
	 * @version 1.0
	 * @param idActividad actividad insertada en base da datos 
	 * @throws Exception
	 */
	public void eliminarActividad(Integer idActividad) throws Exception;
	/**
	 * @author yquintana
	 * @date   9/07/2022
	 * @description metodo encargado de 
	 * @version 1.0
	 * @return retorna la lista de actividades sin discriminacion de estos
	 */
	public List<ActividadDTO> listarActividades();
}
