import { TestBed } from '@angular/core/testing';

import { AuthService } from './auth.service';
import { TokenService } from './token.service';
import { HttpService } from './http.service';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { environment } from 'src/environments/environment';
import { Auth } from '@core/modelo/authprofile';

describe('AuthService', () => {
  let service: AuthService;
  let httpController: HttpTestingController;
  const apiEndpointAuth = `${environment.endpoint}/cliente/login`;
  let tokenService: TokenService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [AuthService, TokenService, HttpService]
    });
    service = TestBed.inject(AuthService);
    httpController = TestBed.inject(HttpTestingController);
    tokenService = TestBed.inject(TokenService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  describe('test para login', () => {
    it('deberia retornar un token', (doneFn) => {
      const mockData: Auth = {
        valor: {
          token: '123123123',
          idCliente: 1,
          nombre: 'Jose',
          email: 'Jose@mail.com',
          contrasena: '123',
          documentoIdentidad: '123456',
          tipoMembresia: 'RUBY',
        }
      };
      const email = 'jose@mail.com';
      const contrasena = '123';
      service.login(email, contrasena).subscribe((data) => {
        expect(data).toEqual(mockData);
        doneFn();
      });
      //http config
      const req = httpController.expectOne(apiEndpointAuth);
      req.flush(mockData);
    });
  });

  it('should call to saveToken', (doneFn) => {
    //Arrange
    const mockData: Auth = {
      valor: {
        token: '123123123',
        idCliente: 1,
        nombre: 'Jose',
        email: 'Jose@mail.com',
        contrasena: '123',
        documentoIdentidad: '123456',
        tipoMembresia: 'RUBY',
      }
    };
    const email = 'nico@gmail.com';
    const password = '1212';
    spyOn(tokenService, 'saveToken').and.callThrough();
    //Act
    service.login(email, password)
      .subscribe((data) => {
        //Assert
        expect(data).toEqual(mockData);
        expect(tokenService.saveToken).toHaveBeenCalledOnceWith('123123123');
        doneFn();
      });
    const req = httpController.expectOne(apiEndpointAuth);
    req.flush(mockData);
  });
});

