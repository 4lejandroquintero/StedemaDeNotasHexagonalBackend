import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FuncionRoutingModule } from './funcion-routing.module';
import { CrearFuncionComponent } from './crear-funcion/crear-funcion.component';
import { ListaFuncionComponent } from './lista-funcion/lista-funcion.component';
import { FuncionComponent } from './funcion/funcion.component';
import { SharedModule } from '@shared/shared.module';


@NgModule({
  declarations: [
    CrearFuncionComponent,
    ListaFuncionComponent,
    FuncionComponent
  ],
  imports: [
    CommonModule,
    FuncionRoutingModule,
    SharedModule
  ],
  providers: []
})
export class FuncionModule { }
