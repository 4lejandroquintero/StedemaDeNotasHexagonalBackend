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
  idBoleto: string | null = null;

  constructor(
    private route: ActivatedRoute,
    private funcionesService: FuncionesService,
    private location: Location
  ) { }

  ngOnInit(): void {
    this.route.paramMap
      .pipe(
        switchMap((params) => {
          this.idBoleto = params.get('id');
          if (this.idBoleto) {
            return this.funcionesService.obtenerListado().pipe(
              map(data => data.filter(funcion => funcion.pelicula.idPelicula == this.idBoleto))
            );
          }
          return [null];
        })
      )
      .subscribe((data) => {
        this.funciones = data;
      });
  }


  volverAtras(){
    this.location.back();
  }

}
