import { Component } from '@angular/core';
import { PeliculasService } from '../../../../../../../../shared/services/pelicula/peliculas.service';
import { Pelicula } from '@models/pelicula/peliculas';

@Component({
  selector: 'app-peliculas',
  templateUrl: './peliculas.component.html',
  styleUrls: ['./peliculas.component.scss']
})
export class PeliculasComponent  {
  peliculas: Pelicula[] = [];
  idPelicula: string;


  constructor(
    private peliculasService: PeliculasService,
  ){
    this.obtenerPeliculas();
  }

  obtenerPeliculas(){
    return this.peliculasService.obtenerListado().subscribe(data => this.peliculas = data);
  }


}
