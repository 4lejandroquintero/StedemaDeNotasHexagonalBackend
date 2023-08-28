import { AuthService } from '@core/services/auth.service';
import { Component, OnInit} from '@angular/core';
import { Cliente } from '@models/cliente/cliente';
import { TokenService } from '@core/services/token.service';


@Component({
  selector: 'app-navbar',
  templateUrl: 'navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent  implements OnInit {
  clienteLogged: Cliente | null;

  constructor(
    private authService: AuthService,
    private tokenService: TokenService,
  ){}

  ngOnInit(): void {
    const token = this.tokenService.getToken();
    if(token){
      this.authService.getProfile().subscribe(data => this.clienteLogged = data);

    }
  }

  logOut(){
    this.authService.logOut();
  }
}
