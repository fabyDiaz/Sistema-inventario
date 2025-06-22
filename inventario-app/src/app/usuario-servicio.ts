import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Usuario } from './usuario';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsuarioServicio {

  private urlBase = "http://localhost:8080/inventario-app/auth";
  private clienteHttp = inject(HttpClient);
  
  constructor() { }

  agregarUsuario(usuario: Usuario):Observable<Object>{
      //return this.clienteHttp.post(this.urlBase, usuario);
      return this.clienteHttp.post(`${this.urlBase}/nuevo-usuario`, usuario);
  }

  login(usuario: string, contrasena: string): Observable<any> {
    /*return this.clienteHttp.post<{ token: string }>(`${this.urlBase}/login`, {
      usuario,
      contrasena
    });*/

    const body = { usuario, contrasena };
    return this.clienteHttp.post<any>(`${this.urlBase}/login`, body, {
    headers: {
      'Content-Type': 'application/json'
    }
  });
  }

  guardarToken(token: string): void {
    localStorage.setItem('token', token);
  }

  obtenerToken(): string | null {
    return localStorage.getItem('token');
  }

  cerrarSesion(): void {
    localStorage.removeItem('token');
  }

  estaAutenticado(): boolean {
    return !!this.obtenerToken();
  }


}
