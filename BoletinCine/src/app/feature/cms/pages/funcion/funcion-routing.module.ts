import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FuncionComponent } from './funcion/funcion.component';
import { CrearFuncionComponent } from './crear-funcion/crear-funcion.component';
import { ListaFuncionComponent } from './lista-funcion/lista-funcion.component';

const routes: Routes = [
  {
    path: '',
    component: FuncionComponent,
    children: [
      {
        path:'',
        redirectTo: 'crear',
        pathMatch: 'full'
      },
      {
        path: 'crear',
        component: CrearFuncionComponent
      },
      {
        path: 'listar',
        component: ListaFuncionComponent
      },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FuncionRoutingModule { }
