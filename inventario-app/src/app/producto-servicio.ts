import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Producto } from './producto';

@Injectable({
  providedIn: 'root'
})
export class ProductoServicio {

  private urlBase="http://localhost:8080/inventario-app";
  private clienteHttp = inject(HttpClient);

  /*obtenerProductosLista():Observable<Producto[]>{
    return this.clienteHttp.get<Producto[]>(this.urlBase);
  }*/

  agregarProducto(producto: Producto): Observable<Object>{
      return this.clienteHttp.post(`${this.urlBase}/agregar-producto`, producto);
  }

    obtenerMisProductos(): Observable<Producto[]> {
    return this.clienteHttp.get<Producto[]>(`${this.urlBase}/mis-productos`);
  }

  obtenerProductoPorId(id: number){
    return this.clienteHttp.get<Producto>(`${this.urlBase}/producto/${id}`);
  }

  editarProducto(id: number, producto: Producto){
    return this.clienteHttp.put(`${this.urlBase}/producto/${id}`, producto);
  }

  eliminarProducto(id: number): Observable<Object>{
    return this.clienteHttp.delete(`${this.urlBase}/producto/${id}`);
  }

}
