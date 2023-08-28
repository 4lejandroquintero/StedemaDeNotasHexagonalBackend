// @ts-nocheck
import { NgModule, ErrorHandler } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SecurityGuard } from './guard/security.guard';
import { HTTP_INTERCEPTORS, HttpClient } from '@angular/common/http';
import { TokenInterceptor } from './interceptor/token-interceptor';
import { AuthInterceptor } from './interceptor/auth-interceptor';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HttpService } from './services/http.service';
import { ManejadorError } from './interceptor/manejador-error';
import { RouterModule } from '@angular/router';
import { ImgComponent } from './components/img/img.component';
import { FooterComponent } from './components/footer/footer.component';

import { NotfoundComponent } from './components/notfound/notfound.component';
import { BootstrapmaterialModule } from '@shared/bootstrapmaterial/bootstrapmaterial.module';

@NgModule({
  declarations: [NavbarComponent, ImgComponent, FooterComponent, NotfoundComponent],
  imports: [
    CommonModule,
    RouterModule,
    BootstrapmaterialModule
  ],
  exports: [NavbarComponent, ImgComponent, FooterComponent, NotfoundComponent],
  providers: [
    HttpService,
    HttpClient,
    SecurityGuard,
    { provide: HTTP_INTERCEPTORS, useClass: TokenInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },
    { provide: ErrorHandler, useClass: ManejadorError }
  ]
})
export class CoreModule { }
