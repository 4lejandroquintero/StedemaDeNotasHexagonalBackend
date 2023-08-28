import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { TokenService } from '@core/services/token.service';

@Injectable({
  providedIn: 'root'
})
export class SecurityGuard implements CanActivate {
  constructor(
    private router: Router,
    private tokenService: TokenService
  ){}
  canActivate():  boolean  {
    const token = this.tokenService.getToken();
    if(!token){
      this.router.navigate(['/home']);
      return false;
    }
    return true;
  }

}
