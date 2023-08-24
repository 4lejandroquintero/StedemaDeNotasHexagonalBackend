import { HttpService } from './../../../../../../core/services/http.service';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Factura } from 'src/app/feature/cms/pages/factura/shared/model/factura';


@Injectable()
export class FacturasService {

  factura: Factura;

  private API_URL = `${environment.endpoint}/factura`;

  constructor(
    private http: HttpService,
  ) {}

  convertirData(idCliente: number, idBoleto: number){
    this.factura.idBoleto = idBoleto;
    this.factura.idCliente = idCliente;
    return this.factura;
  }


  crear(data: Factura){
    return this.http.doPost(this.API_URL, data );
  }

  obtenerListado(){
    return this.http.doGet(this.API_URL);
  }

  obtenerPorID(id: string){
    return this.http.doGet(`${this.API_URL}/${id}`);
  }

}
