import { TestBed } from '@angular/core/testing';

import { FuncionesService } from './funciones.service';
import { HttpService } from '@core/services/http.service';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { Funcion } from '@shared/models/funcion/funcion';
import { generateManyFunciones } from '@shared/models/funcion/funcion.mock';
import { environment } from 'src/environments/environment';

describe('FuncionesService', () => {
  let service: FuncionesService;
  let httpMockController: HttpTestingController;
  const apiEndpointFunciones = `${environment.endpoint}/funcion`;


  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers:[FuncionesService, HttpService]
    });
    httpMockController = TestBed.inject(HttpTestingController);
    service = TestBed.inject(FuncionesService);
  });

  afterEach(() => {
    httpMockController.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  describe('tests obtener listado funciones', () => {
    it('deberia retonar lista de funciones', () =>{
      const mockData: Funcion[] = generateManyFunciones(2);
      service.obtenerListado().subscribe((data) => {
        expect(data.length).toEqual(2);
        expect(data).toEqual(mockData);
      });
      //httpConfig

      const req = httpMockController.expectOne(apiEndpointFunciones);
      expect(req.request.method).toBe('GET');
      req.flush(mockData);
    });

  });
});
