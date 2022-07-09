package com.todosistemas.pruebatecnica.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author yquintana
 * @date   9/07/2022
 * @description clase Empleado encargada de representar el empleado en la base de datos
 * @version 1.0
 */
@Entity
@Table(name = "empleado")
@XmlRootElement
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdEmpleado")
    private Integer idEmpleado;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "Apellido")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "NumeroIdentificacion")
    private String numeroIdentificacion;
    @Column(name = "TipoIdentificacion")
    private String tipoIdentificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleado")
    private List<ActividadPorEmpleado> actividadPorEmpleadoList;
}
