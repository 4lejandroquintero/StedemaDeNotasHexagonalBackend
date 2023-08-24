import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpService } from '@core-service/http.service';
import { Funcion } from '@models/funcion/funcion';

@Injectable()
export class FuncionesService {

  private API_URL = `${environment.endpoint}/funcion`;

  constructor(private http: HttpService) { }

  crear(data: Funcion){
    return this.http.doPost(this.API_URL, data);
  }

  obtenerListado(){
    return this.http.doGet<Funcion[]>(this.API_URL);
  }

  obtenerPorID(id: string){
    return this.http.doGet(`${this.API_URL}/${id}`);
  }

}
