// @ts-nocheck
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FuncionesRoutingModule } from './funciones-routing.module';
import { TableroComponent } from './components/tablero/tablero.component';
import { FuncionesComponent } from './components/funciones/funciones.component';
import { FuncionesService } from '@shared/services/funcion/funciones.service';


@NgModule({
  declarations: [TableroComponent, FuncionesComponent],
  imports: [
    CommonModule,
    FuncionesRoutingModule
  ],
  providers: [FuncionesService]
})
export class FuncionesModule { }
