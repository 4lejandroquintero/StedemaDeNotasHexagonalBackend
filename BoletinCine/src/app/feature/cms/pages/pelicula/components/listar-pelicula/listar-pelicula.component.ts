import { PeliculasService } from '../../../../../../shared/services/pelicula/peliculas.service';
import { Component, OnInit } from '@angular/core';
import { Pelicula } from '@models/pelicula/peliculas';


@Component({
  selector: 'app-listar-pelicula',
  templateUrl: './listar-pelicula.component.html',
  styleUrls: ['./listar-pelicula.component.scss']
})
export class ListarPeliculaComponent implements OnInit {

  peliculas: Pelicula[] = [];

  displayedColumns: string[] = ['idPelicula', 'nombrePelicula', 'sinopsisPelicula', 'categoriaEdad','imagen'];

  dataSource = this.peliculas;

  constructor(
    private peliculasService: PeliculasService,
  ) { }

  ngOnInit(): void {
    this.peliculasService.obtenerListado()
      .subscribe(data => {
        this.peliculas = data;
      });
  }


}
