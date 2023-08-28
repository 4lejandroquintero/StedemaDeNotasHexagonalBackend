// @ts-nocheck
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MembresiasComponent } from './components/membresias.component';

const routes: Routes = [
  {
    path: '',
    component: MembresiasComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MembresiasRoutingModule { }
