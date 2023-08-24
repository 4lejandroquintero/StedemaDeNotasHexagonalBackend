import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Pelicula } from '@models/pelicula/peliculas';
import { HttpService } from '@core/services/http.service';

@Injectable()
export class PeliculasService {
  private API_URL = `${environment.endpoint}/pelicula`;

  constructor(protected http: HttpService) { }

  public guardar(pelicula: Pelicula){
    return this.http.doPost<Pelicula, boolean>(this.API_URL, pelicula);
  }

  public obtenerListado(){
    return this.http.doGet<Pelicula[]>(this.API_URL);
  }

  public obtenerPorID(idPelicula: string){
    return this.http.doGet<Pelicula>(`${this.API_URL}/${idPelicula}`);
  }

  public getUrl(){
    return this.API_URL;
  }

}
