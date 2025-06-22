import { Component } from '@angular/core';
import { RouterModule,  RouterOutlet} from '@angular/router';
import {ProductoLista} from "./producto-lista/producto-lista";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterModule,  RouterOutlet],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {
  protected title = 'inventario-app';
}
