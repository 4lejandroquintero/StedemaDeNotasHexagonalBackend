import { TestBed } from '@angular/core/testing';

import { PagosService } from './pagos.service';
import { HttpService } from '@core/services/http.service';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { PagoDTO, ValorRetornoPago } from '@shared/models/pago/pago';
import { environment } from 'src/environments/environment';
import { generateOnePago } from '@shared/models/pago/pago.mock';

describe('PagosService', () => {
  let service: PagosService;
  let httpController: HttpTestingController;
  const apiEndpointPago = `${environment.endpoint}/pagos`;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [HttpService, PagosService]
    });
    service = TestBed.inject(PagosService);
    httpController = TestBed.inject(HttpTestingController);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  describe('metodo crear de pago', () => {
    it('deberia generar pago', (doneFn) =>{
      //Arrange
      const mockData: ValorRetornoPago = {
        valor: 1
      };
      const dtoPago: PagoDTO = {
        idFactura: 1,
        valorAPagar: 50000,
      };

      //Act
      service.crear(dtoPago).subscribe((data)=>{
        //Assert
        expect(data).toEqual(mockData);
        expect(data.valor).toEqual(1);
        doneFn();
      });

      const req = httpController.expectOne(apiEndpointPago);
      expect(req.request.method).toBe('POST');
      req.flush(mockData);
    });
  });

  describe('metodo obtener pago', () => {
    it('deberia retornar un pago realizado', (doneFn) => {
      //Arrange
      const mockData = generateOnePago(); //mockdeFactura
      const idPago = '1';

      //Act
      service.obtenerPorID(idPago).subscribe(data => {
        //Assert
        expect(data).toBe(mockData);
        doneFn();
      });

      const req = httpController.expectOne(`${apiEndpointPago}/${idPago}`);
      expect(req.request.method).toBe('GET');
      req.flush(mockData);
    });
  });
});
