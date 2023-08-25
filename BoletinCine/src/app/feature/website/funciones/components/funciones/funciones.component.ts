import { map, switchMap } from 'rxjs/operators';
import { Funcion } from '@models/funcion/funcion';
import { FuncionesService } from '@shared/services/funcion/funciones.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-funciones',
  templateUrl: './funciones.component.html',
  styleUrls: ['./funciones.component.scss']
})
export class FuncionesComponent implements OnInit {
  funciones: Funcion[] = [];
  idBoleto: number | null = null;
  longitudFunciones: number;

  constructor(
    private route: ActivatedRoute,
    private funcionesService: FuncionesService,
    private location: Location
  ) { }

  ngOnInit(): void {
    this.route.paramMap
      .pipe(
        switchMap((params) => {
          this.idBoleto =parseInt(params.get('id'), 10);
          if (this.idBoleto) {
            return this.funcionesService.obtenerListado().pipe(
              map(data => data.filter(funcion => parseInt(funcion.pelicula.idPelicula, 10) === this.idBoleto))
            );
          }
          return [null];
        })
      )
      .subscribe((data) => {
        this.funciones = data;
        this.longitudFunciones = this.funciones.length;
      });
  }


  volverAtras(){
    this.location.back();
  }

}
