import { Cliente } from '@models/cliente/cliente';

import { tap, switchMap } from 'rxjs/operators';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpService } from './http.service';
import { TokenService } from './token.service';
import { Auth } from '@core/modelo/authprofile';

import { BehaviorSubject } from 'rxjs';

interface ComandoLogin{
  correo: string;
  contrasena: string;
}

@Injectable()
export class AuthService {

  public dataCliente: Cliente | null = null;
  public cliente = new BehaviorSubject<Cliente | null>(null);
  // eslint-disable-next-line @typescript-eslint/member-ordering
  public cliente$ = this.cliente.asObservable();

  private API_URL = `${environment.endpoint}/cliente`;

  constructor(
    private http: HttpService,
    private tokenService: TokenService
  ) { }



  login(correo: string, contrasena: string){
    return this.http.doPost<ComandoLogin, Auth >(`${this.API_URL}/login`, {correo, contrasena})
      .pipe(
        tap( response => {
          this.tokenService.saveToken(response.valor.token);
          this.tokenService.saveIdUser((response.valor.idCliente).toString());
        }
        )
      );
  }

  loginAndGet(correo: string, contrasena: string){
    return this.login(correo, contrasena).pipe(switchMap(()=> this.getProfile()));
  }

  logOut(){
    this.tokenService.borrarDatos();
    this.cliente = null;
  }

  getProfile(){
    return this.http.doGet<Cliente>(`${this.API_URL}/full/${this.tokenService.getidCliente()}`).pipe(
      tap( user => (this.setCliente(user)))
    );
  }
  setCliente(u: Cliente){
    this.dataCliente = u;
    this.cliente.next(this.dataCliente);
  }
}
