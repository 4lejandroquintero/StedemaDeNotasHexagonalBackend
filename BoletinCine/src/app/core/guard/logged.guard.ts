import { Injectable } from '@angular/core';
import {CanActivate, Router, UrlTree } from '@angular/router';
import { TokenService } from '@core/services/token.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoggedGuard implements CanActivate {
  constructor(
    private router: Router,
    private tokenService: TokenService

  ){}
  canActivate(): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    const token = this.tokenService.getToken();
    if(token){
      this.router.navigate(['/home']);
      return false;
    }
    return true;
  }
}
