import { CookieService } from 'ngx-cookie-service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';

import { CoreModule } from '@core/core.module';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';



import { BootstrapmaterialModule } from '@shared/bootstrapmaterial/bootstrapmaterial.module';
import { AngularmaterialModule } from '@shared/angularmaterial/angularmaterial.module';
import { AuthService } from '@core/services/auth.service';
import { HttpService } from '@core/services/http.service';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    CoreModule,
    //Styles
    AngularmaterialModule,
    BootstrapmaterialModule
  ],
  providers: [CookieService, AuthService, HttpService],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})


export class AppModule { }
