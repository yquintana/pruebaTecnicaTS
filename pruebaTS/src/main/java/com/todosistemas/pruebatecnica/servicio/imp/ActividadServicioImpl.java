package com.todosistemas.pruebatecnica.servicio.imp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.todosistemas.pruebatecnica.comunes.GeneralCTE;
import com.todosistemas.pruebatecnica.comunes.MensajesCTE;
import com.todosistemas.pruebatecnica.dao.ActividadDao;
import com.todosistemas.pruebatecnica.dao.ActividadPorEmpleadoDao;
import com.todosistemas.pruebatecnica.dto.ActividadDTO;
import com.todosistemas.pruebatecnica.modelo.Actividad;
import com.todosistemas.pruebatecnica.modelo.ActividadPorEmpleado;
import com.todosistemas.pruebatecnica.modelo.Empleado;
import com.todosistemas.pruebatecnica.servicio.IActividadServicio;
import lombok.extern.slf4j.Slf4j;
/**
 * @author yquintana
 * @date   9/07/2022
 * @description clase ActividadServicioImpl encargada de la logica de negocio de las actividaes
 * @version 1.0
 */
@Service
@Slf4j
public class ActividadServicioImpl implements IActividadServicio{

	@Autowired
    private ActividadDao actividadDao;	
	@Autowired
	private ActividadPorEmpleadoDao actividadEmpleadoDao;	
	@Autowired
	private ModelMapper modelMapper;	
	private ZoneId zonaHoraria = ZoneId.of(GeneralCTE.ZONA_HORARIA_BOGOTA);
	
	@Override
	public ActividadDTO crearActividad(ActividadDTO actividadDTO) throws Exception  {
		Date fecha = Date.from(LocalDateTime.now().atZone(zonaHoraria).toInstant()
				.atOffset(ZoneOffset.UTC).toInstant());	
		try {
		Actividad actividad=modelMapper.map(actividadDTO, Actividad.class);	
		actividad.setEstado(GeneralCTE.ESTADO_REGISTRADO);
		actividad.setFechaCreacion(fecha);
		actividad =actividadDao.save(actividad);		
		// creando empleado y actividad
		ActividadPorEmpleado actividadPorEmpleado = 
				ActividadPorEmpleado.builder()
				.idActividad(actividad)
				.idEmpleado(Empleado.builder().
						idEmpleado(actividadDTO.getIdIntEmpleado()).build())
				.build(); 		
		 actividadPorEmpleado=actividadEmpleadoDao.save(actividadPorEmpleado);
		 actividadDTO=modelMapper.map(actividad, ActividadDTO.class);
		 actividadDTO.setIdIntEmpleado(actividadPorEmpleado.getIdEmpleado().getIdEmpleado()); 		
		return actividadDTO;
		} catch (Exception e) {
			log.error(MensajesCTE.MENSAJE_ERROR_LOG,e);
			throw new Exception(MensajesCTE.MSG_ERROR_CREAR_ACTIVIDAD);
		}
	}

	@Override
	public ActividadDTO actualizarActividad(ActividadDTO actividadDTO,Integer idActividad) throws Exception {
		Date fecha = Date.from(LocalDateTime.now().atZone(zonaHoraria).toInstant()
				.atOffset(ZoneOffset.UTC).toInstant());	
		Integer idEmpleado = actividadDTO.getIdIntEmpleado();
		try {			
			ActividadPorEmpleado actividadEmpleado=actividadEmpleadoDao.consultarPorIdActividad(idActividad);	
			if(actividadEmpleado ==null)
			   throw new Exception(MensajesCTE.MSG_ERROR_ACTIVIDAD_NO_ENCONTRADA);
			Actividad actividadDb=actividadEmpleado.getIdActividad();
            Empleado empleadoDb = actividadEmpleado.getIdEmpleado();
			Actividad actividad=modelMapper.map(actividadDTO, Actividad.class);	
			actividad.setFechaModificacion(fecha);
			actividad.setFechaCreacion(actividadDb.getFechaCreacion());
			actividad.setIdActividad(actividadDb.getIdActividad());
			actividad =actividadDao.save(actividad);		
			if(!empleadoDb.getIdEmpleado().equals(idEmpleado)) {			
				actividadEmpleadoDao.eliminarPorIdActividad(idActividad);
				// creando empleado y actividad
				ActividadPorEmpleado actividadPorEmpleado = 
						ActividadPorEmpleado.builder()
						.idActividad(actividad)
						.idEmpleado(Empleado.builder().
								idEmpleado(actividadDTO.getIdIntEmpleado()).build())
						.build();
				 actividadEmpleadoDao.save(actividadPorEmpleado);
			}			
		
			 actividadDTO=modelMapper.map(actividad, ActividadDTO.class);
			 actividadDTO.setIdIntEmpleado(idEmpleado); 		
			return actividadDTO;
		} catch (Exception e) {
			log.error(MensajesCTE.MENSAJE_ERROR_LOG,e);
			throw new Exception(MensajesCTE.MSG_ERROR_ACTUALIZAR_ACTIVIDAD);
		}
		
	}

	@Override
	@Transactional
	public void eliminarActividad(Integer idActividad) throws Exception{
		try {			
			ActividadPorEmpleado actividadEmpleado=actividadEmpleadoDao.consultarPorIdActividad(idActividad);	
			if(actividadEmpleado ==null)
			   throw new Exception(MensajesCTE.MSG_ERROR_ACTIVIDAD_NO_ENCONTRADA);			
			actividadEmpleadoDao.delete(actividadEmpleado);
			actividadDao.delete(actividadEmpleado.getIdActividad());	
		
		} catch (Exception e) {
			log.error(MensajesCTE.MENSAJE_ERROR_LOG,e);
			throw new Exception(MensajesCTE.MSG_ERROR_ELIMINAR_ACTIVIDAD);
		}
		
	}

	@Override
	public List<ActividadDTO> listarActividades() {
		return	actividadEmpleadoDao.findAllByOrderByIdActividadPorEmpleadoDesc().stream().map(actividadEmpleado->{			
			LocalDate  fechaAsignacion = actividadEmpleado.getIdActividad().getFechaEjecucion().toInstant()
				      .atZone(zonaHoraria)
				      .toLocalDate();
            LocalDate actual = LocalDate.now();          
            Period periodo = Period.between(fechaAsignacion, actual);
            ActividadDTO actividadDTO = modelMapper.map(actividadEmpleado.getIdActividad(), ActividadDTO.class);
            actividadDTO.setNombreEmpleado(actividadEmpleado.getIdEmpleado().getNombre()+" "+actividadEmpleado.getIdEmpleado().getApellido());
            actividadDTO.setDiasDiferencia(periodo.getDays());
            actividadDTO.setAniosDiferencia(periodo.getYears());
            actividadDTO.setMesesDiferencia(periodo.getMonths());
            actividadDTO.setIdIntEmpleado(actividadEmpleado.getIdEmpleado().getIdEmpleado());
			return actividadDTO;
		}).collect(Collectors.toList());
	}


}
