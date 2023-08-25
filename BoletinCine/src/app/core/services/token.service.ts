import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  constructor() { }

  saveToken(token: string){
    localStorage.setItem('token', token);
  }

  getToken(){
    return localStorage.getItem('token');
  }

  saveIdUser(idCliente: string){
    localStorage.setItem('idCliente', idCliente);
  }

  public getidCliente(){
    return localStorage.getItem('idCliente');
  }

  borrarDatos(){
    localStorage.removeItem('token');
    localStorage.removeItem('idCliente');
  }

}
