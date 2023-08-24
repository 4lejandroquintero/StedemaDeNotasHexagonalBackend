import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { PeliculasService } from './peliculas.service';
import { environment } from 'src/environments/environment';
import { HttpService } from '@core/services/http.service';

describe('PeliculasService', () => {
  let httpMock: HttpTestingController;
  let service: PeliculasService;
  const apiEndpointPeliculas = `${environment.endpoint}/pelicula`;

  beforeEach(() => {
    const injector = TestBed.configureTestingModule({
      imports:[HttpClientTestingModule],
      providers:[PeliculasService, HttpService]
    });
    httpMock = injector.inject(HttpTestingController);
    service = TestBed.inject(PeliculasService);
    TestBed.configureTestingModule({});
    service = TestBed.inject(PeliculasService);
  });

  it('should be created', () => {
    const peliculaService: PeliculasService = TestBed.inject(PeliculasService);
    expect(peliculaService).toBeTruthy();
  });

  it('deberia listar peliculas', () => {
    const peliculas = {
      data: [
        { idPelicula: '1', nombrePelicula: 'Avatar', sinopsisPelicula: 'Raza Espacial', imagenPortada: 'urlImagen', categoriaEdadPelicula: '+12'},
        { idPelicula: '2', nombrePelicula: 'Avatar 2', sinopsisPelicula: 'Raza Espacial', imagenPortada: 'urlImagen', categoriaEdadPelicula: '+12'}
      ]
    };
    service.obtenerListado().subscribe(dataPelicula => {
      expect(dataPelicula.length).toBe(2);
      expect(dataPelicula).toEqual(peliculas);
    });
    const req = httpMock.expectOne(apiEndpointPeliculas);
    expect(req.request.method).toBe('GET');
    req.flush(peliculas);
  });


});
