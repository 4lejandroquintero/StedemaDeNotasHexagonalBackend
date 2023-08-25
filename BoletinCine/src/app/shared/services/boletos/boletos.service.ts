import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpService } from '@core/services/http.service';
import { Boleto, CreateBoletoDTO } from '@models/boleto/boleto';
import { ValorBoletoReserva } from '@shared/models/boleto/boleto';


@Injectable()
export class BoletosService   {

  idCliente: number;
  idBoleto: number;
  private API_URL = `${environment.endpoint}/boleto`;

  constructor(
    private http: HttpService,
  ){}

  public crear(data: CreateBoletoDTO) {
    return this.http.doPost<CreateBoletoDTO, ValorBoletoReserva>(this.API_URL, data);
  }

  public obtenerListado() {
    return this.http.doGet<Boleto[]>(this.API_URL);
  }

}
