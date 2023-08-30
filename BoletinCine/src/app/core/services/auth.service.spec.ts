import { TestBed } from '@angular/core/testing';

import { AuthService } from './auth.service';
import { TokenService } from './token.service';
import { HttpService } from './http.service';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { environment } from 'src/environments/environment';
import { Auth } from '@core/modelo/authprofile';
import { switchMap, tap } from 'rxjs';

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

const clienteMock = {
  id: 1,
  nombre: 'Jose',
  email: 'jose@mail.com',
  contrasena: '123',
  documentoIdentidad: '12345',
  tipoMembresia: 'RUBY'
};


describe('AuthService', () => {
  let service: AuthService;
  let httpController: HttpTestingController;
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
      const apiEndpointAuth = `${environment.endpoint}/cliente/login`;

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
    const apiEndpointAuth = `${environment.endpoint}/cliente/login`;
    //Arrange
    const email = 'jose@mail.com';
    const password = '123';
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
  it('deberia iniciar sesión y obtener datos de perfil', (dnFn) => {
    const email = 'jose@mail.com';
    const password = '123';

    service.loginAndGet(email, password);
    service.login(email, password).pipe(switchMap(() => service.getProfile()));
    service.loginAndGet(email, password).pipe(() => service.getProfile().pipe(tap(
      data => expect(data).toEqual(clienteMock)
    )));

    dnFn();
  });
  it('deberia setear dato a subscribe de cliente', () => {
    service.setCliente(clienteMock);
    service.dataCliente = clienteMock;
    expect(service.dataCliente).toEqual(clienteMock);
    service.cliente.subscribe(data => {
      expect(data).toEqual(service.dataCliente);
    });
  });

  it('deberia eliminar datos de usuario autenticado', () => {
    spyOn(tokenService, 'borrarDatos');
    service.logOut();
    tokenService.borrarDatos();
    service.cliente = null;
    expect(tokenService.borrarDatos).toHaveBeenCalled();
    expect(service.cliente).toBe(null);
  });

  it('deberia obtener perfil cliente', () => {
    spyOn(tokenService, 'getidCliente').and.returnValue('1');
    const apiEndpointAuth = `${environment.endpoint}/cliente/full/1`;
    const mockCliente = clienteMock;

    service.getProfile().subscribe( data => {
      expect(data).toEqual(mockCliente);
    }
    );
    const req = httpController.expectOne(apiEndpointAuth);
    expect(req.request.method).toBe('GET');
    req.flush(mockCliente);
    httpController.verify();
  });
});

