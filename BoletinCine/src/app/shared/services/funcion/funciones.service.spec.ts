import { TestBed } from '@angular/core/testing';

import { FuncionesService } from './funciones.service';
import { HttpService } from '@core/services/http.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';

describe('FuncionesService', () => {
  let service: FuncionesService;


  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers:[FuncionesService, HttpService]
    });
    service = TestBed.inject(FuncionesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
