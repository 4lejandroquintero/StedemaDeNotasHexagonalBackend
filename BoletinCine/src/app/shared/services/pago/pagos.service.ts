import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpService } from '@core-service/http.service';
import { HttpParams } from '@angular/common/http';
import { Pago, IdPago, PagoDTO } from '@shared/models/pago/pago';

@Injectable({
  providedIn: 'root'
})
export class PagosService {

  private API_URL = `${environment.endpoint}/pagos`;


  constructor(private http: HttpService) { }

  crear(data: Pago){
    return this.http.doPost<Pago, IdPago>(this.API_URL, data);
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
    return this.http.doGet<PagoDTO>(`${this.API_URL}/${id}`);
  }
}
