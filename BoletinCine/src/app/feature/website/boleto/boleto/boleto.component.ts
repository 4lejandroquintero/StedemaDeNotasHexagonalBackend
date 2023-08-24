import { AsientosService } from '../asientos/service/asientos.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-boleto',
  templateUrl: './boleto.component.html',
  styleUrls: ['./boleto.component.scss']
})
export class BoletoComponent{
  asientos = [];
  nombrePelicula: string;
  constructor(
    private asientosService: AsientosService,
  ){}


  obtenerListaSeleccionados(){
    this.asientosService.asientosSeleccionados$.subscribe(data => this.asientos = data);
  }
  controladorEvento($event){
    this.nombrePelicula = $event;
  }

}
