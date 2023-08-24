import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CmsRoutingModule } from './cms-routing.module';
import { LayoutComponent } from './components/layout/layout.component';

import { SharedModule } from '@shared/shared.module';
import { PeliculaComponent } from './pages/pelicula/components/pelicula/pelicula.component';
import { AngularmaterialModule } from '@shared/angularmaterial/angularmaterial.module';
import { RegistrarseComponent } from './pages/registrarse/registrarse.component';
import { HttpService } from '@core/services/http.service';
import { ClientesService } from './pages/cliente/shared/service/clientes.service';
import { AuthService } from '@core/services/auth.service';

@NgModule({
  declarations: [
    LayoutComponent,
    PeliculaComponent,
    RegistrarseComponent,
  ],
  imports: [
    CommonModule,
    CmsRoutingModule,
    SharedModule,
    AngularmaterialModule,
  ],
  providers: [
    HttpService,
    ClientesService,
    AuthService
  ]
})
export class CmsModule { }
