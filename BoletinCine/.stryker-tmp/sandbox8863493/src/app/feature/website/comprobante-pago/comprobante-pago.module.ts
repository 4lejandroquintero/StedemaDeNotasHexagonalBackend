// @ts-nocheck
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ComprobantePagoRoutingModule } from './comprobante-pago-routing.module';
import { ComprobantePagoComponent } from './components/comprobante-pago.component';
import { PagosService } from '@shared/services/pago/pagos.service';


@NgModule({
  declarations: [ComprobantePagoComponent],
  imports: [
    CommonModule,
    ComprobantePagoRoutingModule
  ],
  providers:[PagosService]
})
export class ComprobantePagoModule { }
