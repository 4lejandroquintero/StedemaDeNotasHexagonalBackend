/* eslint-disable @typescript-eslint/dot-notation */
import { ActivatedRoute } from '@angular/router';
import { BoletosService } from '@shared/services/boletos/boletos.service';
import { AsientosService } from './service/asientos.service';
import { Component, DoCheck, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { generarAsientos } from './totalasientos';
import { Funcion } from '@shared/models/funcion/funcion';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-asientos',
  templateUrl: './asientos.component.html',
  styleUrls: ['./asientos.component.scss']
})
export class AsientosComponent implements OnInit, DoCheck{
  @Input() funcion: Funcion;
  @Output() nombrePelicula = new EventEmitter<string>();
  asientosSeleccionados = [];
  opcionesAsiento = [];
  numAsientosSeleccionados = 0;
  boleto: any = {};
  idFuncion: string | null = null;
  nombrePeli: string | null = null;
  asientosConfirmados = false;
  continuacionProceso = true;
  cancelarAsientos = true;

  valor: number;


  constructor(
    private boletosService: BoletosService,
    private asientosService: AsientosService,
    private route: ActivatedRoute ){
    this.opcionesAsiento = generarAsientos();
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.idFuncion = params.get('idFuncion');
      this.nombrePeli = params.get('nombrePeli');
    });
    this.valorNombrePelicula();
  }

  ngDoCheck(){
    if(this.asientosSeleccionados.length === 0){
      this.asientosConfirmados = true;
    }
    if(this.asientosSeleccionados.length > 0){
      this.asientosConfirmados = false;
    }
  }
  valorNombrePelicula(){
    this.nombrePelicula.emit(this.nombrePeli);
  }

  obtenerAsientosSeleccionados(opcionesAsiento){
    this.asientosService.obtenerListaAsientos(opcionesAsiento);
  }

  crearBoleto(){
    this.boleto.idFuncion = parseInt(this.idFuncion);
    this.boleto.cantidadAsientos = this.numAsientosSeleccionados;
    this.boleto.numeroAsientos = this.asientosSeleccionados.toString();
    this.boletosService.crear(this.boleto).subscribe((data)=>(this.valor = data.valor, console.log(this.valor),this.alertaExitosa()));
    this.asientosConfirmados = true;
    this.cancelarAsientos = false;
    this.continuacionProceso = false;

  }


  filtrarSeleccionados(){
    this.asientosSeleccionados = this.opcionesAsiento.filter(option => option.isTaken).map(option => option.asiento) ;
    this.numAsientosSeleccionados = this.asientosSeleccionados.length;
    return this.asientosSeleccionados;
  }

  cancelarConfirmacion(){
    this.opcionesAsiento = generarAsientos();
    this.cancelarAsientos = true;
    this.continuacionProceso = true;
  }

  alertaExitosa(){
    return Swal.fire({
      position: 'center',
      icon: 'success',
      title: 'Asientos confirmados exitosamente',
      showConfirmButton: false,
      timer: 1000
    });
  }
}
