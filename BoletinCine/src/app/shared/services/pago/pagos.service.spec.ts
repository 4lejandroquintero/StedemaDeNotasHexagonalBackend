import { HttpClient, HttpHandler } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';

import { PagosService } from './pagos.service';
import { HttpService } from '@core/services/http.service';

describe('PagosService', () => {
  let service: PagosService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [HttpService, PagosService, HttpClient, HttpHandler]
    });
    service = TestBed.inject(PagosService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
  it('deberia traer url de api', ()=> {
    expect(service.getUrl()).toBe('http://localhost:8083/cine/pagos');
  });
});
