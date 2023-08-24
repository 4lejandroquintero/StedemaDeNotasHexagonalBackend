import { AuthService } from '@core/services/auth.service';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpService } from '@core/services/http.service';
import { Boleto, CreateBoletoDTO } from '@models/boleto/boleto';
import { tap } from 'rxjs/operators';
import { rtaBoletoReserva } from '@shared/models/boleto/boleto';


@Injectable()
export class BoletosService   {

  idCliente: number;
  idBoleto: number;
  private API_URL = `${environment.endpoint}/boleto`;

  constructor(
    private http: HttpService,
    private authService: AuthService,
  ){}


  obtenerIdCliente(){
    this.authService.cliente$.subscribe(data => this.idCliente = data.id);
  }


  public crear(data: CreateBoletoDTO) {
    return this.http.doPost<CreateBoletoDTO, rtaBoletoReserva>(this.API_URL, data).pipe(tap((valor) => console.log(valor)));
  }

  public obtenerListado() {
    return this.http.doGet<Boleto[]>(this.API_URL);
  }

  public obtenerPorID(id: string) {
    return this.http.doGet(`${this.API_URL}/${id}`);
  }

  public obtenerPorFuncion(idFuncion: string) {
    return this.http.doGet(`${this.API_URL}/funcion/${idFuncion}`);
  }

}
