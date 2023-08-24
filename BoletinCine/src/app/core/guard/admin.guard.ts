import { AuthService } from '@core/services/auth.service';
import { Injectable } from '@angular/core';
import { CanActivate,  Router,  UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AdminGuard implements CanActivate {

  constructor(
    private router: Router,
    private authService: AuthService
  ){}

  canActivate(): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    return this.authService.cliente$.pipe(
      map(cliente => {
        if(cliente?.nombre === 'admin'){
          return true;
        }else{
          this.router.navigate(['/home']);
          return false;
        }
      })
    );
  }

}
