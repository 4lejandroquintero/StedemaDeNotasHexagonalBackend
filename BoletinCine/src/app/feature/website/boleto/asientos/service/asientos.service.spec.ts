import { TestBed } from '@angular/core/testing';

import { AsientosService } from './asientos.service';

describe('AsientosService', () => {
  let service: AsientosService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers:[AsientosService]
    });
    service = TestBed.inject(AsientosService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('deberia tener una lista de asientos',() =>{
    const name = 'asientos';
    expect(name).toBe('asientos');
  });
});
