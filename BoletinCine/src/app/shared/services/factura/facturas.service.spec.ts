import { TestBed } from '@angular/core/testing';

import { FacturasService } from './facturas.service';
import { HttpService } from '@core/services/http.service';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { FacturaDTO } from '@shared/models/factura/factura';
import { ValorRetornoFactura } from '@shared/models/factura/facturaID';
import { environment } from 'src/environments/environment';
import { generateOneFactura } from '@shared/models/factura/factura.mock';

describe('FacturasService', () => {
  let service: FacturasService;
  let httpController: HttpTestingController;
  const apiEndpointFactura = `${environment.endpoint}/factura`;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [FacturasService, HttpService,]
    });
    service = TestBed.inject(FacturasService);
    httpController = TestBed.inject(HttpTestingController);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  describe('metodo crear de factura', () => {
    it('deberia crear factura', (doneFn) =>{
      //Arrange
      const mockData: ValorRetornoFactura = {
        valor: 2
      };
      const facturadto: FacturaDTO = {
        idCliente: 1,
        idBoleto: 1,
      };

      //Act
      service.crear(facturadto).subscribe((data)=>{
        //Assert
        expect(data).toEqual(mockData);
        expect(data.valor).toEqual(2);
        doneFn();
      });

      const req = httpController.expectOne(apiEndpointFactura);
      expect(req.request.method).toBe('POST');
      req.flush(mockData);
    });
  });

  describe('metodo obtener factura', () => {
    it('deberia retornar una factura', (doneFn) => {
      //Arrange
      const mockData = generateOneFactura(); //mockdeFactura
      const idFactura = 1;

      //Act
      service.obtenerPorID(idFactura).subscribe(data => {
        //Assert
        expect(data).toBe(mockData);
        doneFn();
      });

      const req = httpController.expectOne(`${apiEndpointFactura}/${idFactura}`);
      expect(req.request.method).toBe('GET');
      req.flush(mockData);
    });
  });
});
