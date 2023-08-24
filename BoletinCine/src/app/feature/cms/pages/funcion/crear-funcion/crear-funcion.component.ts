import { FuncionesService } from '@shared/services/funcion/funciones.service';
import { Pelicula } from '@models/pelicula/peliculas';
import { PeliculasService } from '../../../../../shared/services/pelicula/peliculas.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { CategoriaAudio, CategoriaSubtitulos, CategoriaVisual } from '../shared/model/categorias';
import { Sala, Teatro } from '../shared/model/salas';

@Component({
  selector: 'app-crear-funcion',
  templateUrl: './crear-funcion.component.html',
  styleUrls: ['./crear-funcion.component.scss']
})
export class CrearFuncionComponent implements OnInit {

  categoriasAudio: CategoriaAudio[] = [
    {value: 'DOBLAJE LATINO', viewValue: 'DOBLAJE LATINO'},
    {value: 'ORIGINAL', viewValue: 'INGLES'},
    {value: 'FRANCES', viewValue: 'FRANCES'},
  ];
  categoriasSubtitulos: CategoriaSubtitulos[] = [
    {value: 'ESPAÑOL', viewValue: 'ESPAÑOL'},
    {value: 'INGLES', viewValue: 'INGLES'},
    {value: 'FRANCES', viewValue: 'FRANCES'},
  ];
  categoriasVisual: CategoriaVisual[] = [
    {value: '2D', viewValue: '2D'},
    {value: '3D', viewValue: '3D'},
    {value: '5D', viewValue: '5D'},
  ];

  salas: Sala[] = [
    {value: 'Sala #1'},
    {value: 'Sala #2'},
    {value: 'Sala #3'},
    {value: 'Sala #4'},
    {value: 'Sala #5'},
  ];

  teatros: Teatro[] = [
    {value: 'Teatro Silver '},
    {value: 'Teatro Gold'},
    {value: 'Teatro Platino'},
    {value: 'Teatro Diamante'},
  ];

  peliculas: Pelicula[] = [];

  funcionForm: FormGroup;

  constructor(
    protected funcionesService: FuncionesService,
    protected peliculasService: PeliculasService,
    private fb: FormBuilder) {
    this.funcionForm = this.fb.group({});
  }

  ngOnInit(): void {
    this.construirFormularioFuncion();
    this.peliculasService.obtenerListado()
      .subscribe(data => {
        this.peliculas = data;
      });
  }

  crear() {
    console.log(this.funcionForm.value);
    if(this.funcionForm.valid){
      this.funcionesService.crear(this.funcionForm.value).subscribe(()=>(window.alert('Funcion creada')));
    }
  }

  private construirFormularioFuncion() {
    this.funcionForm = new FormGroup({
      idPelicula: new FormControl('', [Validators.required]),
      nombreTeatro: new FormControl('', [Validators.required]),
      salaFuncion: new FormControl('', [Validators.required]),
      diaFuncion: new FormControl('', [Validators.required]),
      horaFuncion: new FormControl('', [Validators.required]),
      valorFuncion: new FormControl(0, [Validators.required]),
      categoriaAudioFuncion: new FormControl('', [Validators.required]),
      categoriaSubtitulosFuncion: new FormControl('', [Validators.required]),
      categoriaVisualFuncion: new FormControl('', [Validators.required]),
    });
  }


}
