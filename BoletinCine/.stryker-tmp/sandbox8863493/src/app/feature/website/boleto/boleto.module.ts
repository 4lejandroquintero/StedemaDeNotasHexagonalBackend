// @ts-nocheck
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BoletoRoutingModule } from './boleto-routing.module';
import { AsientosComponent } from './asientos/asientos.component';
import { BoletoComponent } from './boleto/boleto.component';
import { AsientosService } from './asientos/service/asientos.service';
import { BoletosService } from '@shared/services/boletos/boletos.service';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [AsientosComponent, BoletoComponent],
  imports: [
    CommonModule,
    BoletoRoutingModule,
    FormsModule
  ],
  providers:[AsientosService, BoletosService]
})
export class BoletoModule { }
