// @ts-nocheck
import { TestBed } from '@angular/core/testing';

import { TokenService } from './token.service';

describe('TokenService', () => {
  let service: TokenService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TokenService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('deberia remover tokens de localstorage', () => {
    localStorage.setItem('token', 'tokenValue');
    localStorage.setItem('idCliente', 'idValue');

    service.borrarDatos();

    expect(localStorage.getItem('token')).toBeNull();
    expect(localStorage.getItem('idCliente')).toBeNull();
  });
});
