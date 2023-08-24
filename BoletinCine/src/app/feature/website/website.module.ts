import { SwiperModule } from 'swiper/angular';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LayoutComponent } from './layout/layout.component';
import { CoreModule } from '@core/core.module';
import { WebsiteRoutingModule } from './website-routing.module';
import { SharedModule } from '@shared/shared.module';
import { AuthService } from '@core/services/auth.service';
import { FuncionesService } from '../../shared/services/funcion/funciones.service';
import { HttpService } from '@core/services/http.service';
import { FacturasService } from '@shared/services/factura/facturas.service';
import { TokenService } from '@core/services/token.service';

@NgModule({
  declarations: [LayoutComponent],
  imports: [
    CommonModule,
    WebsiteRoutingModule,
    SwiperModule,
    SharedModule,
    CoreModule,
  ],
  providers:[
    AuthService, FuncionesService, HttpService,FacturasService, TokenService
  ]
})
export class WebsiteModule { }
