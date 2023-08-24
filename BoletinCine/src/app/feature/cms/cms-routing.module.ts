import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LayoutComponent } from './components/layout/layout.component';
import { RegistrarseComponent } from './pages/registrarse/registrarse.component';


const routes: Routes = [
  {
    path:'',
    component: LayoutComponent,
    children: [
      {
        path:'',
        redirectTo: 'peliculas',
        pathMatch: 'full'
      },
      {
        path: 'peliculas',
        loadChildren: () => import('./pages/pelicula/pelicula.module').then(mod => mod.PeliculaModule)
      },
      {
        path: 'funciones',
        loadChildren: () => import('./pages/funcion/funcion.module').then(mod => mod.FuncionModule)
      },
      {
        path: 'registrarse', component: RegistrarseComponent },
    ]
    //   {
    //     path: 'funciones',
    //     component:
    //   },
    //   {
    //     path: 'boletos',
    //     component:
    //   },
    //   {
    //     path: 'facturas',
    //     component:
    //   },
    //   {
    //     path: 'pagos',
    //     component:
    //   },
    // ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CmsRoutingModule { }
