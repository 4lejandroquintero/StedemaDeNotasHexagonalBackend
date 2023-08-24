import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FuncionesComponent } from './components/funciones/funciones.component';

const routes: Routes = [
  {
    path: '',
    component: FuncionesComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FuncionesRoutingModule { }
