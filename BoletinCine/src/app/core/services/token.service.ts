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
    const token = localStorage.getItem('token');
    return token;
  }

  saveIdUser(idCliente: string){
    localStorage.setItem('idCliente', idCliente);
  }

  public getidCliente(){
    const id = localStorage.getItem('idCliente');
    return id;
  }

  borrarDatos(){
    localStorage.removeItem('token');
    localStorage.removeItem('idCliente');
  }

}
