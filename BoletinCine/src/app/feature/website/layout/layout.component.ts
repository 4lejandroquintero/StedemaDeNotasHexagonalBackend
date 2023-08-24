import { Component, OnInit  } from '@angular/core';
import { AuthService } from '@core/services/auth.service';
import { TokenService } from '@core/services/token.service';


@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.scss']
})
export class LayoutComponent implements OnInit  {
  constructor(
    private authService: AuthService,
    private tokenService: TokenService
  ){}

  ngOnInit(){
    const token = this.tokenService.getToken();
    if(token){
      this.authService.getProfile().subscribe();
    }
  }


}
