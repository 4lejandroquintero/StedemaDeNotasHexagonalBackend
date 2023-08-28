// @ts-nocheck
import { Component, Input } from '@angular/core';
import { Pelicula } from '@models/pelicula/peliculas';
@Component({
  selector: 'app-pelicula',
  templateUrl: './pelicula.component.html',
  styleUrls: ['./pelicula.component.scss']
})
export class PeliculaComponent {
  @Input()
  pelicula!: Pelicula;
}