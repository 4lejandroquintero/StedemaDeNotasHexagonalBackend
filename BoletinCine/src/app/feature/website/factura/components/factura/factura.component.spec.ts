import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { FacturaComponent } from './factura.component';
import { FacturasService } from '@shared/services/factura/facturas.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';
import { ValorRetornoFactura } from '@shared/models/factura/facturaID';
import { generateOneFactura } from '@shared/models/factura/factura.mock';
import { TokenService } from '@core/services/token.service';
import { Factura } from '@shared/models/factura/factura';


describe('FacturaComponent', () => {
  let component: FacturaComponent;
  let fixture: ComponentFixture<FacturaComponent>;
  let facturaService: jasmine.SpyObj<FacturasService>;
  let tokenService: jasmine.SpyObj<TokenService>;

  const mockActivatedRoute = {
    paramMap: of({
      get: (param: string) => {
        if (param === 'idBoleto') {
          return '1';
        }
        return null;
      },
    }),
  };


  beforeEach(async () => {
    const mockService = jasmine.createSpyObj('FacturaService', ['crear', 'obtenerPorID']);
    const tokenServiceSpy = jasmine.createSpyObj('TokenService', ['getidCliente']);
    await TestBed.configureTestingModule({
      declarations: [ FacturaComponent ],
      imports: [RouterTestingModule, HttpClientTestingModule],
      providers: [
        {provide: ActivatedRoute, useValue: mockActivatedRoute},
        {provide: FacturasService, useValue: mockService},
        {provide: TokenService, useValue: tokenServiceSpy}
      ]
    })
      .compileComponents();

    fixture = TestBed.createComponent(FacturaComponent);
    facturaService = TestBed.inject(FacturasService) as jasmine.SpyObj<FacturasService>;
    tokenService = TestBed.inject(TokenService) as jasmine.SpyObj<TokenService>;
    component = fixture.componentInstance;


    const facturaValorCreacion: ValorRetornoFactura = {
      valor: 1,
    };


    const facturaMock: Factura = {...generateOneFactura(), idFactura: 1};
    tokenService.getidCliente.and.returnValue('123');
    facturaService.crear.and.returnValue(of(facturaValorCreacion));
    facturaService.obtenerPorID.and.returnValue(of(facturaMock));
    fixture.detectChanges();


    expect(component.idBoleto).toEqual('1');
    expect(facturaService.crear).toHaveBeenCalled();
    expect(facturaService.obtenerPorID).toHaveBeenCalledWith(facturaValorCreacion.valor);
    expect(component.factura).toEqual(facturaMock);
    expect(component.dataFactura.idBoleto).toEqual(1);
    expect(component.dataFactura.idCliente).toEqual(123);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

describe('FacturaComponent Invalido', () => {
  let component: FacturaComponent;
  let fixture: ComponentFixture<FacturaComponent>;
  let facturaService: jasmine.SpyObj<FacturasService>;
  let tokenService: jasmine.SpyObj<TokenService>;

  const mockActivatedRoute = {
    paramMap: of({
      get: (param: string) => {
        if (param === 'idBoleto') {
          return null;
        }
        return null;
      },
    }),
  };


  beforeEach(async () => {
    const mockService = jasmine.createSpyObj('FacturaService', ['crear', 'obtenerPorID']);
    const tokenServiceSpy = jasmine.createSpyObj('TokenService', ['getidCliente']);
    await TestBed.configureTestingModule({
      declarations: [ FacturaComponent ],
      imports: [RouterTestingModule, HttpClientTestingModule],
      providers: [
        {provide: ActivatedRoute, useValue: mockActivatedRoute},
        {provide: FacturasService, useValue: mockService},
        {provide: TokenService, useValue: tokenServiceSpy}
      ]
    })
      .compileComponents();

    fixture = TestBed.createComponent(FacturaComponent);
    facturaService = TestBed.inject(FacturasService) as jasmine.SpyObj<FacturasService>;
    tokenService = TestBed.inject(TokenService) as jasmine.SpyObj<TokenService>;
    component = fixture.componentInstance;


    const facturaValorCreacion: ValorRetornoFactura = {
      valor: 1,
    };

    const facturaMock: Factura = {...generateOneFactura(), idFactura: 1};
    tokenService.getidCliente.and.returnValue('123');
    facturaService.crear.and.returnValue(of(facturaValorCreacion));
    facturaService.obtenerPorID.and.returnValue(of(facturaMock));
    fixture.detectChanges();


    expect(component.dataFactura.idBoleto).toBeUndefined();
    expect(component.dataFactura.idCliente).toBeUndefined();
    expect(facturaService.crear).not.toHaveBeenCalled();
    expect(facturaService.obtenerPorID).not.toHaveBeenCalled();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
