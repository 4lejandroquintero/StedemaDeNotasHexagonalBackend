import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PeliculaComponent } from './components/pelicula/pelicula.component';
import { CrearPeliculaComponent } from './components/crear-pelicula/crear-pelicula.component';
import { ListarPeliculaComponent } from './components/listar-pelicula/listar-pelicula.component';

const routes: Routes = [
  {
    path: '',
    component: PeliculaComponent,
    children: [
      {
        path:'',
        redirectTo: 'crear',
        pathMatch: 'full'
      },
      {
        path: 'crear',
        component: CrearPeliculaComponent
      },
      {
        path: 'listar',
        component: ListarPeliculaComponent
      },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PeliculaRoutingModule { }
