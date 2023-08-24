import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CarrouselComponent } from './components/carrousel/carrousel.component';
import { HomeComponent } from './components/inicio/home.component';
import { SharedModule } from '@shared/shared.module';
import { ListaModule } from './components/lista/lista.module';
import { HomeRoutingModule } from './home-routing.module';
import { PeliculasService } from '../../../shared/services/pelicula/peliculas.service';


@NgModule({
  declarations: [CarrouselComponent, HomeComponent],
  imports: [
    CommonModule,
    HomeRoutingModule,
    SharedModule,
    ListaModule,
  ],
  providers:[PeliculasService]
})
export class HomeModule { }
