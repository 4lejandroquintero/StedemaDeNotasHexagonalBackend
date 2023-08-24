import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SobrenosotrosRoutingModule } from './sobrenosotros-routing.module';
import { SobrenosotrosComponent } from './components/sobrenosotros.component';
import { SharedModule } from '@shared/shared.module';


@NgModule({
  declarations: [SobrenosotrosComponent],
  imports: [
    CommonModule,
    SobrenosotrosRoutingModule,
    SharedModule
  ]
})
export class SobrenosotrosModule { }
