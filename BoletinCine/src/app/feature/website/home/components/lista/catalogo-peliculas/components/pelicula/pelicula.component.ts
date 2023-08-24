import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Pelicula } from '@models/pelicula/peliculas';

@Component({
  selector: 'app-pelicula',
  templateUrl: './pelicula.component.html',
  styleUrls: ['./pelicula.component.scss']
})
export class PeliculaComponent {
  @Input() pelicula!: Pelicula;
  @Output() obtenerIDPelicula = new EventEmitter<string>();

  constructor() { }

  visualizarFuncionesPorPelicula(){
    this.obtenerIDPelicula.emit(this.pelicula.idPelicula.toString());
  }

}
