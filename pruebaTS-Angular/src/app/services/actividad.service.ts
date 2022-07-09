import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Actividad } from '../models/Actividad';

@Injectable({
  providedIn: 'root'
})
export class ActividadService {

  constructor(private http: HttpClient) { }

  consultaTodasActividades() {
    return this.http.get("http://localhost:8080/listarActividades");
  }


  crearActividad(actividad: Actividad) {
    return this.http.post("http://localhost:8080/crearActividad", actividad);
  }

  actualizarActividad(actividad: Actividad, idActividad: number) {
    return this.http.put("http://localhost:8080/actualizarActividad/" + idActividad, actividad);
  }

  eliminarActividad(idActividad: number) {
    return this.http.delete("http://localhost:8080/eliminarActividad/" + idActividad);
  }

}
