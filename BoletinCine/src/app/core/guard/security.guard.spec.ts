import { TestBed, inject } from '@angular/core/testing';

import { SecurityGuard } from './security.guard';
import { TokenService } from '@core/services/token.service';
import { Router } from '@angular/router';

describe('SecurityGuard', () => {
  let guardian: SecurityGuard;
  let tokenService: jasmine.SpyObj<TokenService>;
  let router: jasmine.SpyObj<Router>;

  beforeEach(() => {
    const routerSpy = jasmine.createSpyObj('Router', ['navigate']);
    const tokenServiceSpy = jasmine.createSpyObj('TokenService', ['getToken']);
    TestBed.configureTestingModule({
      providers: [SecurityGuard,
        {provide: TokenService, useValue: tokenServiceSpy},
        {provide: Router, useValue: routerSpy},]
    });
    guardian = TestBed.inject(SecurityGuard);
    tokenService = TestBed.inject(TokenService) as jasmine.SpyObj<TokenService>;
    router = TestBed.inject(Router) as jasmine.SpyObj<Router>;
  });

  it('should ...', inject([SecurityGuard], (guard: SecurityGuard) => {
    expect(guard).toBeTruthy();
  }));

  it('deberia retornar al home si no está logueado', (dnFn) => {
    tokenService.getToken.and.returnValue(null);
    const canActivate = guardian.canActivate();
    expect(canActivate).toBe(false);
    expect(router.navigate).toHaveBeenCalledWith(['/home']);

    dnFn();
  });

  it('deberia retornar al home si está logueado', (dnFn) => {
    tokenService.getToken.and.returnValue('token del cliente');
    const canActivate = guardian.canActivate();
    expect(canActivate).toBe(true);
    dnFn();
  });
});
