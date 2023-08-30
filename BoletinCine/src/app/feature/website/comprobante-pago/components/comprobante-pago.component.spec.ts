import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComprobantePagoComponent } from './comprobante-pago.component';
import { PagosService } from '@shared/services/pago/pagos.service';
import { RouterTestingModule } from '@angular/router/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';
import { generateOnePago } from '@shared/models/pago/pago.mock';

describe('ComprobantePagoComponent', () => {
  let component: ComprobantePagoComponent;
  let fixture: ComponentFixture<ComprobantePagoComponent>;
  let pagoService: jasmine.SpyObj<PagosService>;

  beforeEach(async () => {
    const pagoServiceSpy = jasmine.createSpyObj('PagosService', ['obtenerPorID']);
    await TestBed.configureTestingModule({
      declarations: [ ComprobantePagoComponent ],
      imports: [RouterTestingModule, HttpClientTestingModule],
      providers: [
        {provide: PagosService, useValue: pagoServiceSpy},
        {provide: ActivatedRoute, useValue: {paramMap: of({get: (param: string) => {if (param === 'idPago'){return '123';}}})}},

      ]
    })
      .compileComponents();

    fixture = TestBed.createComponent(ComprobantePagoComponent);
    pagoService = TestBed.inject(PagosService) as jasmine.SpyObj<PagosService>;
    component = fixture.componentInstance;

    const mockPago = generateOnePago();
    pagoService.obtenerPorID.and.returnValue(of(mockPago));

    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('deberia generar componente ngOnInit', () => {
    const mockPago = generateOnePago();
    pagoService.obtenerPorID.and.returnValue(of(mockPago));
    component.ngOnInit();
    fixture.detectChanges();

    expect(pagoService.obtenerPorID).toHaveBeenCalled();
    expect(component.pago).toEqual(mockPago);
    expect(component.idPago).toEqual('123');
  });
});
