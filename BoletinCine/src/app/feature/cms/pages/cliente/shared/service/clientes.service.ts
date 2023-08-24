import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpService } from '@core/services/http.service';
import { Cliente } from 'src/app/feature/cms/pages/cliente/shared/model/cliente';
import { HttpParams } from '@angular/common/http';

@Injectable()
export class ClientesService {
  private API_URL = `${environment.endpoint}/cliente`;

  constructor(private http: HttpService) { }

  crear(data: Cliente){
    return this.http.doPost(this.API_URL, data);
  }

  obtenerListado(limit?: number, offset?: number){
    let params = new HttpParams();
    if(limit != undefined && offset != undefined){
      params = params.set('limit',limit);
      params = params.set('offset',offset);
    }
    return this.http.doGet(this.API_URL, { params });
  }

  obtenerPorID(id: string){
    return this.http.doGet(`${this.API_URL}/${id}`);
  }
}
