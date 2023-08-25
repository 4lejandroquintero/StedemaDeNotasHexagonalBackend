import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpService } from '@core-service/http.service';
import { Funcion } from '@models/funcion/funcion';

@Injectable()
export class FuncionesService {

  private API_URL = `${environment.endpoint}/funcion`;

  constructor(protected http: HttpService) { }

  obtenerListado(){
    return this.http.doGet<Funcion[]>(this.API_URL);
  }

}
