import { Component, OnInit } from '@angular/core';
import { FuncionesService } from '@shared/services/funcion/funciones.service';
import { Funcion } from '@models/funcion/funcion';


@Component({
  selector: 'app-lista-funcion',
  templateUrl: './lista-funcion.component.html',
  styleUrls: ['./lista-funcion.component.scss']
})
export class ListaFuncionComponent implements OnInit {

  funciones: Funcion[] = [];

  displayedColumns: string[] = ['portadaPelicula', 'idFuncion', 'nombreTeatro', 'salaFuncion', 'diaFuncion','horaFuncion','valorFuncion',
    'categoriaAudio', 'categoriaSub', 'categoriaVisual' ];

  dataSource = this.funciones;

  constructor(

    private funcionService: FuncionesService,
  ) { }

  ngOnInit(): void {
    this.funcionService.obtenerListado()
      .subscribe(data => {
        this.funciones = data;
        console.log(this.funciones);
      });

  }


}
