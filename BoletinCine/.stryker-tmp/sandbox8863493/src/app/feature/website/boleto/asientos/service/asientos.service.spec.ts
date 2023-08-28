// @ts-nocheck
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
    const mockListaAsientos = [
      {
        asiento: 'A1',
        isTaken: true,
      },
      {
        asiento: 'A2',
        isTaken: true,
      },
      {
        asiento: 'A3',
        isTaken: true,
      },
    ];
    service.obtenerListaAsientos(mockListaAsientos);
    service.asientoSeleccionadoSubject.subscribe( data => {
      expect(data).toEqual(mockListaAsientos.filter(opcion => opcion.isTaken).map(opcion => opcion.asiento));
    });
  });


});
