import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Usuario } from './usuario';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsuarioServicio {

  private urlBase = "http://localhost:8080/inventario-app/usuarios";
  private clienteHttp = inject(HttpClient);
  
  constructor() { }

  agregarUsuario(usuario: Usuario):Observable<Object>{
      return this.clienteHttp.post(this.urlBase, usuario);
  }
}
