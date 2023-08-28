
/*
import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PeliculasComponent } from './peliculas.component';
import { PeliculasService } from '@shared/services/pelicula/peliculas.service';

import { HttpClientTestingModule } from '@angular/common/http/testing';
import { PeliculaComponent } from '../pelicula/pelicula.component';
import { of } from 'rxjs';

describe('PeliculasComponent', () => {
  let component: PeliculasComponent;
  let fixture: ComponentFixture<PeliculasComponent>;
  let peliculasService: jasmine.SpyObj<PeliculasService>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PeliculasComponent, PeliculaComponent],
      imports: [HttpClientTestingModule],
      providers: [{provide: PeliculasService, useValue: peliculasService}]
    })
      .compileComponents();

    fixture = TestBed.createComponent(PeliculasComponent);
    component = fixture.componentInstance;
    peliculasService = TestBed.inject(PeliculasService) as jasmine.SpyObj<PeliculasService>;

    const mockPeliculas = [
      { idPelicula: 1, nombrePelicula: 'Avatar', sinopsisPelicula: 'Raza Espacial', imagenPortada: 'urlImagen', categoriaEdadPelicula: '+12'},
      { idPelicula: 2, nombrePelicula: 'Avatar 2', sinopsisPelicula: 'Raza Espacial', imagenPortada: 'urlImagen', categoriaEdadPelicula: '+12'}
    ];
    peliculasService.obtenerListado.and.returnValue(of(mockPeliculas));

    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

});
*/
// @ts-nocheck

