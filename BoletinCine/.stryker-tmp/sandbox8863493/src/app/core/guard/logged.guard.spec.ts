// @ts-nocheck
import { TestBed } from '@angular/core/testing';

import { LoggedGuard } from './logged.guard';
import { TokenService } from '@core/services/token.service';
import { Router } from '@angular/router';

describe('LoggedGuard', () => {
  let guard: LoggedGuard;
  let tokenService: jasmine.SpyObj<TokenService>;
  let router: jasmine.SpyObj<Router>;

  beforeEach(() => {
    const routerSpy = jasmine.createSpyObj('Router', ['navigate']);
    const tokenServiceSpy = jasmine.createSpyObj('TokenService', ['getToken']);
    TestBed.configureTestingModule({
      providers:[
        LoggedGuard,
        {provide: TokenService, useValue: tokenServiceSpy},
        {provide: Router, useValue: routerSpy},
      ]
    });
    guard = TestBed.inject(LoggedGuard);
    tokenService = TestBed.inject(TokenService) as jasmine.SpyObj<TokenService>;
    router = TestBed.inject(Router) as jasmine.SpyObj<Router>;
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });

  describe('Tests de Usuarios Autenticados', () => {
    it('no deberia dejar acceder al usuario si está autenticado', () => {
      tokenService.getToken.and.returnValue('123');

      const canActivate = guard.canActivate();
      expect(canActivate).toBe(false);
      expect(router.navigate).toHaveBeenCalledWith(['/home']);
    });

    it('deberia dejar acceder al usuario si está autenticado', () => {
      tokenService.getToken.and.returnValue(null);

      const canActivate = guard.canActivate();
      expect(canActivate).toBe(true);
    });
  });
});
