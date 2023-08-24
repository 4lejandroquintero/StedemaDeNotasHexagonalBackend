import { TestBed } from '@angular/core/testing';

import { BoletosService } from './boletos.service';
import { HttpService } from '@core/services/http.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { AuthService } from '@core/services/auth.service';

describe('BoletosService', () => {
  let service: BoletosService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [BoletosService, HttpService, AuthService]
    });
    service = TestBed.inject(BoletosService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
