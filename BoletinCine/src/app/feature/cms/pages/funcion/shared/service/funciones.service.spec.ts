import { TestBed } from '@angular/core/testing';

import { FuncionesService } from '@shared/services/funcion/funciones.service';

describe('FuncionesService', () => {
  let service: FuncionesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FuncionesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
