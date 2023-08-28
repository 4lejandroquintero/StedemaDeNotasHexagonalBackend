// @ts-nocheck
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SobrenosotrosComponent } from './components/sobrenosotros.component';

const routes: Routes = [
  {
    path: '',
    component: SobrenosotrosComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SobrenosotrosRoutingModule { }
