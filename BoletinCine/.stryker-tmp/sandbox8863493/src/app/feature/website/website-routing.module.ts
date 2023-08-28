// @ts-nocheck
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LayoutComponent } from './layout/layout.component';
import { SecurityGuard } from '@core/guard/security.guard';


const routes: Routes = [
  {
    path: '', component: LayoutComponent, children: [
      { path: '', redirectTo: 'home', pathMatch: 'full' },

      {
        path: 'sobrenosotros',
        loadChildren: () => import('./nav/sobrenosotros/sobrenosotros.module').then(mod => mod.SobrenosotrosModule)
      },
      {
        path: 'contactanos',
        loadChildren: () => import('./nav/contactos/contactos.module').then(mod => mod.ContactosModule)
      },
      {
        path: 'membresias',
        loadChildren: () => import('./nav/membresias/membresias.module').then(mod => mod.MembresiasModule)
      },
      {
        path: 'login',
        loadChildren: () => import('./user/login/login.module').then(mod => mod.LoginModule)
      },
      {
        path: 'perfil',
        loadChildren: () => import('./user/perfil/perfil.module').then(mod => mod.PerfilModule)
      },
      {
        path: 'home',
        loadChildren: () => import('./home/home.module').then(mod => mod.HomeModule)
      },
      {
        path: 'funcion/:id',
        loadChildren: () => import('./funciones/funciones.module').then(mod => mod.FuncionesModule),
      },
      {
        path: 'reserva/:nombrePeli/:idFuncion',
        loadChildren: () => import('./boleto/boleto.module').then(mod => mod.BoletoModule),
        canActivate: [SecurityGuard]
      },
      {
        path: 'factura/reserva/:idBoleto',
        loadChildren: () => import('./factura/factura.module').then(mod => mod.FacturaModule),
        canActivate: [SecurityGuard]
      },
      {
        path: 'comprobante/pago/:idPago',
        loadChildren: () => import('./comprobante-pago/comprobante-pago.module').then(mod => mod.ComprobantePagoModule),
        canActivate: [SecurityGuard]
      },
    ]
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class WebsiteRoutingModule { }
