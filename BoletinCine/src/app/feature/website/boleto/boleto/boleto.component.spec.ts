
import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoletoComponent } from './boleto.component';
import { AsientosService } from '../asientos/service/asientos.service';
import { BehaviorSubject } from 'rxjs';

describe('BoletoComponent', () => {
  let component: BoletoComponent;
  let fixture: ComponentFixture<BoletoComponent>;


  beforeEach(async () => {
    const datosSimulados = ['A1', 'A2', 'A3'];
    const asientosServiceMock = { asientosSeleccionados$ :new BehaviorSubject(datosSimulados) };
    await TestBed.configureTestingModule({
      declarations: [ BoletoComponent ],
      providers: [{provide: AsientosService, useValue: asientosServiceMock}]
    })
      .compileComponents();

    fixture = TestBed.createComponent(BoletoComponent);

    component = fixture.componentInstance;
    expect(component.asientos.length).toEqual(0);
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('deberia obtener lista de asientos seleccionados', () => {
    const datosSimulados = ['A1', 'A2', 'A3'];

    component.obtenerListaSeleccionados();

    expect(component.asientos).toEqual(datosSimulados);
  });
  it('deberia definir nombre de pelicula', () => {
    const mockEvento = 'Avengers';

    component.controladorEvento(mockEvento);
    expect(component.nombrePelicula).toEqual(mockEvento);
  });
});
