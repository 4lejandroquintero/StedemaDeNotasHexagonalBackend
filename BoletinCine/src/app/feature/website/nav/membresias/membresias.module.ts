import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MembresiasRoutingModule } from './membresias-routing.module';
import { MembresiasComponent } from './components/membresias.component';


@NgModule({
  declarations: [MembresiasComponent],
  imports: [
    CommonModule,
    MembresiasRoutingModule
  ]
})
export class MembresiasModule { }
