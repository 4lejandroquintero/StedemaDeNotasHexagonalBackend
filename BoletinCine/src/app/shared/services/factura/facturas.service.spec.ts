import { TestBed } from '@angular/core/testing';

import { FacturasService } from './facturas.service';
import { HttpService } from '@core/services/http.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';

describe('FacturasService', () => {
  let service: FacturasService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [FacturasService, HttpService,]
    });
    service = TestBed.inject(FacturasService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
