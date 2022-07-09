import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EmpleadoService {

  constructor(private http: HttpClient) { }


  consultaTodosEmpleados() {
    return this.http.get("http://localhost:8080/consultarEmpleados");
  }
}
