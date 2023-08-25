import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { PeliculasService } from './peliculas.service';

import { Pelicula } from '@shared/models/pelicula/peliculas';
import { HttpService } from '@core/services/http.service';
import { environment } from 'src/environments/environment';

describe('PeliculasService', () => {
  let peliculaService: PeliculasService;
  let httpController: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [
        PeliculasService,
        HttpService,
        [{provide: environment, useValue: environment}]
      ]
    }).compileComponents();
    peliculaService = TestBed.inject(PeliculasService);
    httpController = TestBed.inject(HttpTestingController);
  });

  it('should be create', () => {
    expect(peliculaService).toBeTruthy();
  });

  it('deberia retornar valor de cadena de API', () => {
    const value = peliculaService.getUrl();
    expect(value).toEqual('http://localhost:8083/cine/pelicula');
  });

  describe('test de obtener datos',()=>{
    it('deberia retornar una lista de peliculas', (doneFn) => {
      const mockData: Pelicula[] = [
        { idPelicula: 1, nombrePelicula: 'Avatar', sinopsisPelicula: 'Raza Espacial', imagenPortada: 'urlImagen', categoriaEdadPelicula: '+12'},
        { idPelicula: 2, nombrePelicula: 'Avatar 2', sinopsisPelicula: 'Raza Espacial', imagenPortada: 'urlImagen', categoriaEdadPelicula: '+12'}
      ];
      peliculaService.obtenerListado().subscribe((data)=> {
        expect(data.length).toEqual(mockData.length);
        expect(data).toEqual(mockData);
        doneFn();
      });
      const url = peliculaService.getUrl();
      const req = httpController.expectOne(url);
      req.flush(mockData);
    });
  });
});
