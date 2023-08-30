import { Component, OnInit } from '@angular/core';
import { AuthService } from '@core/services/auth.service';
import { TokenService } from '@core/services/token.service';
import { Cliente } from '@shared/models/cliente/cliente';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
})
export class AppComponent implements OnInit {
  clienteLogged: Cliente | null;
  constructor(
    private authService: AuthService,
    private tokenService: TokenService
  ){}

  ngOnInit(){
    this.obtenerInfoCliente();
  }

  obtenerInfoCliente(){
    const token = this.tokenService.getToken();
    if(token){
      this.authService.getProfile().subscribe(data => this.clienteLogged = data);
    }
  }
}
