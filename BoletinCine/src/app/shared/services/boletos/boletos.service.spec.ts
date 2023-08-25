import { TestBed } from '@angular/core/testing';

import { BoletosService } from './boletos.service';
import { HttpService } from '@core/services/http.service';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { CreateBoletoDTO, ValorBoletoReserva } from '@shared/models/boleto/boleto';
import { environment } from 'src/environments/environment';


describe('BoletosService', () => {
  let service: BoletosService;
  let httpController: HttpTestingController;
  const apiEndpointBoleto = `${environment.endpoint}/boleto`;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [BoletosService, HttpService]
    });
    service = TestBed.inject(BoletosService);
    httpController = TestBed.inject(HttpTestingController);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
  describe('tests metodo de crear boleto', () => {
    it('deberia crear boleto', (doneFn) => {
      //Arrange
      const mockData: ValorBoletoReserva = {
        valor: 2
      };
      const dto: CreateBoletoDTO = {
        cantidadAsientos: 3,
        numeroAsientos: 'A1,A2,A3',
        idFuncion: 1,
      };
      //Act
      service.crear(dto).subscribe((data)=>{
        //Assert
        expect(data).toEqual(mockData);
        expect(data.valor).toEqual(2);
        doneFn();
      });
      const req = httpController.expectOne(apiEndpointBoleto);
      expect(req.request.method).toBe('POST');
      req.flush(mockData);
    });
  });
});
