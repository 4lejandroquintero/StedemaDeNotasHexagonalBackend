import { TestBed } from '@angular/core/testing';

import { AsientosService } from './asientos.service';
import { BehaviorSubject } from 'rxjs';

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

  it('deberia actualizar el subject de asientos seleccionados correctamente', () => {
    const asientosSimulados = [
      { asiento: 'A1', isTaken: true },
      { asiento: 'B3', isTaken: true },
      { asiento: 'C5', isTaken: false },
    ];

    const subjectSimulado = new BehaviorSubject<string[]>([]);
    spyOn(service.asientoSeleccionadoSubject, 'next').and.callFake((data) => {
      subjectSimulado.next(data);
    });

    service.obtenerListaAsientos(asientosSimulados);

    expect(service.asientoSeleccionadoSubject.next).toHaveBeenCalledWith(['A1', 'B3']);
    expect(subjectSimulado.value).toEqual(['A1', 'B3']);
  });


});
