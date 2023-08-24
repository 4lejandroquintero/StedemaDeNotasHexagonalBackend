import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FacturaRoutingModule } from './factura-routing.module';
import { PagoComponent } from './components/pago/pago.component';
import { FacturaComponent } from './components/factura/factura.component';
import { PagosService } from '@shared/services/pago/pagos.service';
import { FacturasService } from '@shared/services/factura/facturas.service';
import { TokenService } from '@core/services/token.service';
import { FormsModule } from '@angular/forms';
import { SharedModule } from '@shared/shared.module';


@NgModule({
  declarations: [PagoComponent, FacturaComponent],
  imports: [
    CommonModule,
    FacturaRoutingModule,
    FormsModule,
    SharedModule
  ],
  providers:[PagosService, FacturasService, TokenService]
})
export class FacturaModule { }
