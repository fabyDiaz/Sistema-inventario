import { Component, inject } from '@angular/core';
import { Producto } from '../producto';
import { ProductoServicio } from '../producto-servicio';

@Component({
  selector: 'app-producto-lista',
  imports: [],
  templateUrl: './producto-lista.html',
})
export class ProductoLista {
  productos: Producto[];

  private productoServicio = inject(ProductoServicio);

  ngOnInit(){
    //cargar los productos 
    this.obtenerProductos();
  }
  private obtenerProductos(): void{
    this.productoServicio.obtenerProductosLista().subscribe(
      {
        next: (datos) => {
          this.productos = datos;
        },
        error: (error) =>{
          console.error("Error al obtener los prodcutos ",error);
        }
      }
    );
  }
}
