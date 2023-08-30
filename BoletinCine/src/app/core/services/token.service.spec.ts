import { TestBed } from '@angular/core/testing';

import { TokenService } from './token.service';

describe('TokenService', () => {
  let service: TokenService;
  //let almacenamientoLocal: jasmine.SpyObj<Storage>;

  beforeEach(() => {
    //const almacenamientoLocalSpy = jasmine.createSpyObj('Storage', ['removeItem', 'setItem', 'getItem']);
    TestBed.configureTestingModule({
      providers:[]
    });
    service = TestBed.inject(TokenService);

  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('deberia remover tokens de localstorage', () => {

    spyOn(localStorage, 'removeItem');
    spyOn(localStorage, 'getItem');

    service.borrarDatos();

    expect(localStorage.removeItem).toHaveBeenCalledWith('token');
    expect(localStorage.removeItem).toHaveBeenCalledWith('idCliente');
    expect(localStorage.removeItem).toHaveBeenCalledTimes(2);
  });

  it('deberia guardar token', ()=>{
    spyOn(localStorage, 'setItem');
    const token = 'valueToken';
    service.saveToken(token);

    expect(localStorage.setItem).toHaveBeenCalledWith('token', token );
    // localStorage.setItem('token', token);
    // const getToken = service.getToken();
    // expect(token).toBe(getToken);
  });

  it('deberia guardar id usuario', ()=>{
    spyOn(localStorage, 'setItem');
    const userID = '123';
    service.saveIdUser(userID);

    expect(localStorage.setItem).toHaveBeenCalledWith('idCliente', userID );
    // localStorage.setItem('token', token);
    // const getToken = service.getToken();
    // expect(token).toBe(getToken);
  });

  it('deberia obtener cliente', ()=> {
    const idCliente = '123';
    spyOn(localStorage, 'getItem').and.returnValue(idCliente);
    const serviceSpy = service.getidCliente();
    expect(serviceSpy).toEqual('123');
    expect(localStorage.getItem).toHaveBeenCalledWith('idCliente');
  });

  it('deberia obtener token', ()=> {
    const token = 'tokenCliente';
    spyOn(localStorage, 'getItem').and.returnValue(token);
    const serviceSpy = service.getToken();
    expect(serviceSpy).toEqual('tokenCliente');
    expect(localStorage.getItem).toHaveBeenCalledWith('token');
  });

  // it('deberia no obtener cliente', ()=> {
  //   const serviceSpy = service.getidCliente();
  //   expect(serviceSpy).toBe(null);
  // });

  it('deberia guardar id user', ()=>{
    const idUser = '123';
    service.saveIdUser(idUser);
    localStorage.setItem('idCliente',idUser);
    expect(localStorage.getItem('idCliente')).toBe('123');
  });
});
