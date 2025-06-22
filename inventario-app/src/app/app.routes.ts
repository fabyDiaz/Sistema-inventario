import { Routes } from '@angular/router';
import { ProductoLista } from './producto-lista/producto-lista';
import { AgregarProducto } from './agregar-producto/agregar-producto';
import { AgregarUsuario } from './agregar-usuario/agregar-usuario';
import { IniciarSesion } from './iniciar-sesion/iniciar-sesion';

//http://localhost:4200/productos
export const routes: Routes = [
    {path:'productos', component: ProductoLista},
    {path:'', redirectTo:'productos',pathMatch: 'full'},
    {path: 'agregar-producto', component: AgregarProducto},
    {path: 'agregar-usuario', component: AgregarUsuario },
    {path: 'iniciar-sesion', component: IniciarSesion}
];
