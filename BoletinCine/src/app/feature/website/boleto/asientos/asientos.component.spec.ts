import { ValorBoletoReserva } from './../../../../shared/models/boleto/boleto';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AsientosComponent } from './asientos.component';
import { BoletosService } from '@shared/services/boletos/boletos.service';
import { HttpService } from '@core/services/http.service';
import { AuthService } from '@core/services/auth.service';
import { AsientosService } from './service/asientos.service';
import { RouterTestingModule } from '@angular/router/testing';
import Swal from 'sweetalert2';
import { of } from 'rxjs';

describe('AsientosComponent', () => {
  let component: AsientosComponent;
  let fixture: ComponentFixture<AsientosComponent>;
  let asientosService: jasmine.SpyObj<AsientosService>;
  let boletosService: jasmine.SpyObj<BoletosService>;

  beforeEach(async () => {
    const asientosServiceSpy = jasmine.createSpyObj('AsientosService', ['obtenerListaAsientos']);
    const boletoServiceSpy = jasmine.createSpyObj('BoletosService', ['crear']);
    await TestBed.configureTestingModule({
      declarations: [AsientosComponent],
      imports: [HttpClientTestingModule, RouterTestingModule],
      providers: [HttpService, AuthService,
        { provide: AsientosService, useValue: asientosServiceSpy },
        { provide: BoletosService, useValue: boletoServiceSpy }
      ]
    })
      .compileComponents();

    asientosService = TestBed.inject(AsientosService) as jasmine.SpyObj<AsientosService>;
    boletosService = TestBed.inject(BoletosService) as jasmine.SpyObj<BoletosService>;
    fixture = TestBed.createComponent(AsientosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('deberia aparecer alerta de inicion sesion correcto', () => {
    const swalFireSpy = spyOn(Swal, 'fire');
    component.alertaExitosa();

    expect(swalFireSpy).toHaveBeenCalledWith({
      position: 'center',
      icon: 'success',
      title: 'Asientos confirmados exitosamente',
      showConfirmButton: false,
      timer: 1000
    } as any);
  });

  it('deberia cambiar valores binding', () => {
    component.cancelarConfirmacion();
    expect(component.cancelarAsientos).toEqual(true);
    expect(component.continuacionProceso).toEqual(true);
  });

  it('deberia cambiar valor asientos confirmados', () => {
    component.asientosSeleccionados = [[], []];
    fixture.detectChanges();
    expect(component.asientosConfirmados).toBeFalsy();
  });

  it('deberia obtener la lista de los asientos', () => {
    const mockAsientos = [];
    component.obtenerAsientosSeleccionados(mockAsientos);
    asientosService.obtenerListaAsientos(mockAsientos);
    expect(asientosService.obtenerListaAsientos).toHaveBeenCalled();
  });

  it('deberia crear boleto', () => {
    const mockBoleto = {
      idBoleto: 2,
      cantidadAsientos: 2,
      numeroAsientos: 'A2,A3',
      idFuncion: 1
    };

    const mockData: ValorBoletoReserva = {
      valor: 1,
    };
    boletosService.crear.and.returnValue(of(mockData));
    component.boleto = mockBoleto;
    component.idFuncion = '2';
    component.numAsientosSeleccionados = 2;
    component.asientosSeleccionados = ['A2,A3'];

    component.crearBoleto();
    expect(component.valor).toBe(mockData.valor);
    expect(component.boleto.idFuncion).toBe(parseInt(component.idFuncion));
    expect(component.boleto.cantidadAsientos).toBe(component.numAsientosSeleccionados);
    expect(component.boleto.numeroAsientos).toBe(component.asientosSeleccionados.toString());


    expect(component.asientosConfirmados).toBeTruthy();
    expect(component.cancelarAsientos).toBeFalsy();
    expect(component.continuacionProceso).toBeFalsy();
    fixture.detectChanges();
  });
});

// expect(component.valor).toBe(data.valor);
//       const swalFireSpy = spyOn(Swal, 'fire');
//       component.alertaExitosa();
//       expect(swalFireSpy).toHaveBeenCalledWith({
//         position: 'center',
//         icon: 'success',
//         title: 'Asientos confirmados exitosamente',
//         showConfirmButton: false,
//         timer: 1000
//       }as any);
