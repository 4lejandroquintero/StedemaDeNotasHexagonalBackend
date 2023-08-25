import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpService } from '@core-service/http.service';
import { Pago, ValorRetornoPago, PagoDTO } from '@shared/models/pago/pago';

@Injectable({
  providedIn: 'root'
})
export class PagosService {

  private API_URL = `${environment.endpoint}/pagos`;
  constructor(protected http: HttpService) { }

  crear(data: PagoDTO){
    return this.http.doPost<PagoDTO, ValorRetornoPago>(this.API_URL, data);
  }
  obtenerPorID(id: string){
    return this.http.doGet<Pago>(`${this.API_URL}/${id}`);
  }

}
