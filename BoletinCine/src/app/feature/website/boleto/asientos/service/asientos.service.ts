import { Asiento } from './../totalasientos';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable()
export class AsientosService {
  asientoSeleccionadoSubject = new BehaviorSubject<string[]>(null);
  asientosSeleccionados$ = this.asientoSeleccionadoSubject.asObservable();
  asientosSeleccionados = [];

  obtenerListaAsientos(listaAsientos: Asiento[]){
    this.asientoSeleccionadoSubject.next(listaAsientos.filter(option => option.isTaken).map(option => option.asiento));
  }


}
