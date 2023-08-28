// @ts-nocheck
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CatalogoPeliculasComponent } from './catalogo-peliculas/catalogo-peliculas.component';
import { PeliculasComponent } from './catalogo-peliculas/components/peliculas/peliculas.component';
import { PeliculaComponent } from './catalogo-peliculas/components/pelicula/pelicula.component';
import { CoreModule } from '@core/core.module';
import { SharedModule } from '@shared/shared.module';
import { PeliculasService } from '@shared/services/pelicula/peliculas.service';
import { RouterModule } from '@angular/router';


@NgModule({
  declarations: [CatalogoPeliculasComponent, PeliculasComponent,PeliculaComponent],
  imports: [
    CommonModule,
    CoreModule,
    SharedModule,
    RouterModule
  ],
  exports: [CatalogoPeliculasComponent, ],
  providers:[PeliculasService]
})
export class ListaModule { }
