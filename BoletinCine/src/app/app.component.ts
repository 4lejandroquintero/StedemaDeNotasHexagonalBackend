//import { TokenService } from '@core/services/token.service';

import { Component, OnInit } from '@angular/core';
import { AuthService } from '@core/services/auth.service';
import { TokenService } from '@core/services/token.service';
import { Cliente } from '@shared/models/cliente/cliente';
//import { TokenService } from '@core/services/token.service';
// import {  OnInit } from '@angular/core';
// import { AuthService } from '@core/services/auth.service';
// import { TokenService } from '@core/services/token.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  clienteLogged: Cliente | null;
  constructor(
    private authService: AuthService,
    private tokenService: TokenService
  ){}

  ngOnInit(){
    const token = this.tokenService.getToken();
    if(token){
      this.authService.getProfile().subscribe(data => this.clienteLogged = data);
    }

  }



}
