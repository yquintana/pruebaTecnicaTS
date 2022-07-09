import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Actividad } from './models/Actividad';
import { ActividadService } from './services/actividad.service';
import { EmpleadoService } from './services/empleado.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
/* 
Descripcion: se realiza funcionalidad de crud para actividades y empleados
Autor: yquintana
Version: 1.0
Fecha: 09/07/2022
*/
export class AppComponent implements OnInit {

  actividades: Actividad[];
  empleados: [];
  formularioActividad: boolean;
  esNuevaActividad: boolean;
  nuevaActividad: any = {};
  formularioEditarActividad: boolean;
  editarActividad: any = {};
  formActividadNuevo: FormGroup;
  formActividadActualizar: FormGroup;
  estados = [
    'Realizada', 'Pendiente'
  ]
  minDate: Date;

  constructor(private servicioActividad: ActividadService,
    private servicioEmpleados: EmpleadoService,
    private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.consultarActividades();
  }

  consultarActividades() {
    this.servicioActividad.consultaTodasActividades().subscribe(resultado => {
      this.actividades = resultado as Actividad[];
    }, (error) => {
      console.error(error);
      console.log('Error' + error);
    });
  }



  consultarEmpleados() {
    this.servicioEmpleados.consultaTodosEmpleados().subscribe(resultado => {
      this.empleados = resultado as [];
    }, (error) => {
      console.error(error);
      console.log('Error' + error);
    });
  }

  configurationValidatorCreate() {
    this.formActividadNuevo = this.formBuilder.group({
      nombre: new FormControl(
        '', Validators.compose([
          Validators.required,
          Validators.minLength(2),
          Validators.maxLength(150),
        ])),
      descripcion: new FormControl('', Validators.compose([
        Validators.required,
        Validators.minLength(2),
        Validators.maxLength(500),
      ])),
      fechaEjecucion: new FormControl('', Validators.compose([
        Validators.required,
        , Validators.min(new Date().getFullYear())
      ])),
      empleado: new FormControl('', Validators.compose([
        Validators.required,
      ]))
    });
  }


  configurationValidatorActualizar() {
    this.formActividadActualizar = this.formBuilder.group({
      nombre: new FormControl(
        '', Validators.compose([
          Validators.required,
          Validators.minLength(2),
          Validators.maxLength(150),
        ])),
      descripcion: new FormControl('', Validators.compose([
        Validators.required,
        Validators.minLength(2),
        Validators.maxLength(500),
      ])),
      estado: new FormControl('', Validators.compose([
        Validators.required
      ])),
      fechaEjecucion: new FormControl('', Validators.compose([
        Validators.required,
        , Validators.min(new Date().getFullYear())
      ])),
      empleado: new FormControl('', Validators.compose([
        Validators.required,
      ]))
    });
  }


  mostrarActualizaActividad(actividad: Actividad) {
    if (!actividad) {
      this.formularioActividad = false;
      return;
    }
    this.formularioEditarActividad = true;
    this.editarActividad = actividad;
    this.consultarEmpleados();
    this.configurationValidatorActualizar();
  }

  mostrarNuevaActividad() {
    this.formularioActividad = true;
    this.esNuevaActividad = true;
    this.minDate = new Date();
    this.consultarEmpleados();
    this.configurationValidatorCreate();
  }

  guardarActividad(actividad: Actividad) {
    if (this.esNuevaActividad) {
      this.servicioActividad.crearActividad(actividad as Actividad).subscribe(resultado => {
        this.ngOnInit();
        this.formularioActividad = false;
      }, (error) => {
        console.error(error);
        console.log('Error' + error);
      });
    }

  }

  actualizarActividad() {
    this.servicioActividad.actualizarActividad(this.editarActividad as Actividad, this.editarActividad.idActividad).subscribe(resultado => {
      this.ngOnInit();
      this.formularioEditarActividad = false;
      this.editarActividad = {};
    }, (error) => {
      console.error(error);
      console.log('Error' + error);
    });


  }

  eliminarActividad(actividad: Actividad) {
    this.servicioActividad.eliminarActividad(actividad.idActividad).subscribe(resultado => {
      this.ngOnInit();
    }, (error) => {
      console.error(error);
      console.log('Error' + error);
    });
  }

  cancelarEditarActividad() {
    this.editarActividad = {};
    this.formularioEditarActividad = false;
  }

  cancelarNuevaActividad() {
    this.nuevaActividad = {};
    this.formularioActividad = false;
    console.log(this.formActividadNuevo);
  }

}
