import { HttpService } from '@core-service/http.service';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Factura, FacturaDTO } from '@models/factura/factura';
import { ValorRetornoFactura } from '@shared/models/factura/facturaID';


@Injectable()
export class FacturasService {

  factura: Factura;

  private API_URL = `${environment.endpoint}/factura`;

  constructor(
    protected http: HttpService,
  ) {}
  crear(data: FacturaDTO){
    return this.http.doPost<FacturaDTO, ValorRetornoFactura >(this.API_URL, data );
  }

  obtenerPorID(id: number){
    const url =  `${this.API_URL}/${id}`;
    return this.http.doGet<Factura>(url);
  }

}
