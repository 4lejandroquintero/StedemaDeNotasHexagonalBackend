import { HttpService } from '@core-service/http.service';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Factura, FacturaDTO } from '@models/factura/factura';
import { IDFactura } from '@shared/models/factura/facturaID';


@Injectable()
export class FacturasService {

  factura: Factura;

  private API_URL = `${environment.endpoint}/factura`;

  constructor(
    protected http: HttpService,
  ) {}

  convertirData(idCliente: number, idBoleto: number){
    this.factura.idCliente = idCliente;
    this.factura.idBoleto = idBoleto;
    return this.factura;
  }


  crear(data: Factura){
    return this.http.doPost<Factura, IDFactura >(this.API_URL, data );
  }

  obtenerListado(){
    return this.http.doGet(this.API_URL);
  }

  obtenerPorID(id: number){
    return this.http.doGet<FacturaDTO>(`${this.API_URL}/${id}`);
  }

}
