import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpService } from '@core-service/http.service';
import { Pago, IdPago, PagoDTO } from '@shared/models/pago/pago';

@Injectable({
  providedIn: 'root'
})
export class PagosService {

  private API_URL = `${environment.endpoint}/pagos`;


  constructor(protected http: HttpService) { }

  crear(data: Pago){
    return this.http.doPost<Pago, IdPago>(this.API_URL, data);
  }

  obtenerListado(){
    return this.http.doGet<PagoDTO[]>(this.API_URL);
  }

  obtenerPorID(id: string){
    return this.http.doGet<PagoDTO>(`${this.API_URL}/${id}`);
  }

  public getUrl(){
    return this.API_URL;
  }
}
