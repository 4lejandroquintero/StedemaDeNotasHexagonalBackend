import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { PeliculasService } from '../../../../../../shared/services/pelicula/peliculas.service';

const LONGITUD_MINIMA_PERMITIDA_TEXTO = 3;
const LONGITUD_MAXIMA_PERMITIDA_TEXTO = 20;
interface Categorias {
  name: string;
  publico: string;
}


@Component({
  selector: 'app-crear-pelicula',
  templateUrl: './crear-pelicula.component.html',
  styleUrls: ['./crear-pelicula.component.scss']
})
export class CrearPeliculaComponent implements OnInit {

  selectedValue: string;
  categoriaControl = new FormControl<Categorias | null>(null, Validators.required);
  selectFormControl = new FormControl('', Validators.required);
  categorias: Categorias[] = [
    {name: 'Ninguna', publico: 'Family Friendly'},
    {name: '+8 Años', publico: 'Infantil'},
    {name: '+14', publico: 'Adolecentes'},
    {name: '+18', publico: 'Mayores de Edad'},
  ];


  peliculaForm: FormGroup;


  constructor(
    protected peliculaService: PeliculasService,
    private fb: FormBuilder) {
    this.peliculaForm = this.fb.group({});
  }

  ngOnInit(): void {
    this.construirFormularioPelicula();
  }
  crear() {
    console.log(this.peliculaForm.value);
    if(this.peliculaForm.valid){
      this.peliculaService.guardar(this.peliculaForm.value).subscribe(()=>(window.alert('Pelicula creada'), this.limpiar()));
    }
  }

  private limpiar(){
    this.peliculaForm.reset();
  }

  private construirFormularioPelicula() {
    this.peliculaForm = new FormGroup({
      nombrePelicula: new FormControl('', [Validators.required]),
      sinopsisPelicula: new FormControl('', [Validators.required, Validators.minLength(LONGITUD_MINIMA_PERMITIDA_TEXTO),
        Validators.maxLength(LONGITUD_MAXIMA_PERMITIDA_TEXTO)]),
      imagenPortada: new FormControl('', [Validators.required]),
      categoriaEdadPelicula: new FormControl('', [Validators.required]),
    });
  }

}
