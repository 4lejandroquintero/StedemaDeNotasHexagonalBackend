// @ts-nocheck
import { Component, Input } from '@angular/core';
import { Funcion } from '@models/funcion/funcion';
@Component({
  selector: 'app-tablero',
  templateUrl: './tablero.component.html',
  styleUrls: ['./tablero.component.scss']
})
export class TableroComponent {
  @Input()
  funcion: Funcion;
  constructor() {}
}