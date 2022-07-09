package com.todosistemas.pruebatecnica.modelo;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author yquintana
 * @date   9/07/2022
 * @description clase ActividadPorEmpleado encargada de representar la actividad y el empleado en la base de datos
 * @version 1.0
 */
@Entity
@Table(name = "actividadporempleado")
@XmlRootElement
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActividadPorEmpleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdActividadPorEmpleado")
    private Integer idActividadPorEmpleado;
    @JoinColumn(name = "IdActividad", referencedColumnName = "IdActividad")
    @OneToOne(optional = false)
    private Actividad idActividad;
    @JoinColumn(name = "IdEmpleado", referencedColumnName = "IdEmpleado")
    @ManyToOne(optional = false)
    private Empleado idEmpleado;

}
