package com.todosistemas.pruebatecnica.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author yquintana
 * @date   9/07/2022
 * @description clase ActividadDTO encargada de representar la actividad en la base de datos
 * @version 1.0
 */
@Entity
@Table(name = "actividad")
@XmlRootElement
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Actividad implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "IdActividad")
	private Integer idActividad;
	@Basic(optional = false)
	@Column(name = "Nombre")
	private String nombre;
	@Basic(optional = false)
	@Column(name = "Descripcion")
	private String descripcion;
	@Column(name = "Estado")
	private String estado;
	@Basic(optional = false)
	@Column(name = "FechaEjecucion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaEjecucion;
	@Column(name = "FechaCreacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;	
	@Column(name = "FechaModificacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaModificacion;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "idActividad")
	private ActividadPorEmpleado actividadPorEmpleado;

}
