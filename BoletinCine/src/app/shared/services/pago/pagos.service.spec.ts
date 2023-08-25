import { TestBed } from '@angular/core/testing';

import { PagosService } from './pagos.service';
import { HttpService } from '@core/services/http.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';

describe('PagosService', () => {
  let service: PagosService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [HttpService, PagosService]
    });
    service = TestBed.inject(PagosService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
