import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ComprobantePagoComponent } from './components/comprobante-pago.component';

const routes: Routes = [
  {
    path:'',
    component: ComprobantePagoComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ComprobantePagoRoutingModule { }
