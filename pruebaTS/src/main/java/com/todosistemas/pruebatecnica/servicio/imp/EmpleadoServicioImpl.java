package com.todosistemas.pruebatecnica.servicio.imp;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.todosistemas.pruebatecnica.dao.EmpleadoDao;
import com.todosistemas.pruebatecnica.dto.EmpleadoDTO;
import com.todosistemas.pruebatecnica.servicio.IEmpleadoServicio;

/**
 * @author yquintana
 * @date   9/07/2022
 * @description clase EmpleadoServicioImpl encargada de la logica de negocio del empleado
 * @version 1.0
 */
@Service
public class EmpleadoServicioImpl implements IEmpleadoServicio{

	@Autowired
	private EmpleadoDao empleadoDao;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public List<EmpleadoDTO> listarEmpleados() {
		return	empleadoDao.findAllByOrderByIdEmpleadoDesc().stream().map(empleado->
			 modelMapper.map(empleado, EmpleadoDTO.class)
		).collect(Collectors.toList());
	}

}
