import { NgModule } from '@angular/core';

import { PeliculaRoutingModule } from './pelicula-routing.module';
import { CrearPeliculaComponent } from './components/crear-pelicula/crear-pelicula.component';
import { ListarPeliculaComponent } from './components/listar-pelicula/listar-pelicula.component';
import { PeliculasService } from '../../../../shared/services/pelicula/peliculas.service';
import { SharedModule } from '@shared/shared.module';

import { NgFor, NgIf } from '@angular/common';


@NgModule({
  declarations: [CrearPeliculaComponent, ListarPeliculaComponent],
  imports: [
    SharedModule,
    PeliculaRoutingModule,
    NgFor, NgIf,

  ],
  providers: [PeliculasService]
})
export class PeliculaModule { }
