// @ts-nocheck
import { waitForAsync, ComponentFixture, TestBed } from '@angular/core/testing';

import { NavbarComponent } from './navbar.component';
import { AuthService } from '@core/services/auth.service';
import { TokenService } from '@core/services/token.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { HttpService } from '@core/services/http.service';
import { BootstrapmaterialModule } from '@shared/bootstrapmaterial/bootstrapmaterial.module';
import { of } from 'rxjs';

describe('NavbarComponent', () => {
  let component: NavbarComponent;
  let fixture: ComponentFixture<NavbarComponent>;
  let authService: jasmine.SpyObj<AuthService>;
  let tokenService: jasmine.SpyObj<TokenService>;

  beforeEach(waitForAsync(() => {
    const tokenServiceSpy =jasmine.createSpyObj('TokenService', ['getToken']);
    const authServiceSpy = jasmine.createSpyObj('AuthService', ['logOut', 'getProfile']);

    TestBed.configureTestingModule({
      declarations: [NavbarComponent],
      imports: [HttpClientTestingModule, BootstrapmaterialModule],
      providers: [TokenService, HttpService,
        {provide: AuthService, useValue: authServiceSpy},
        {provide: TokenService, useValue: tokenServiceSpy},
      ]
    })
      .compileComponents();
    authService = TestBed.inject(AuthService) as jasmine.SpyObj<AuthService>;
    tokenService = TestBed.inject(TokenService) as jasmine.SpyObj<TokenService>;
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NavbarComponent);
    component = fixture.componentInstance;
    const clienteMock = {
      id: 1,
      nombre: 'Jose',
      email: 'jose@mail.com',
      contrasena: '123',
      documentoIdentidad: '12345',
      tipoMembresia: 'RUBY'
    };
    tokenService.getToken.and.returnValue('Token mock de Cliente');

    authService.getProfile.and.returnValue(of(clienteMock));


    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('deberia realizar logOut del perfil', () => {
    component.logOut();
    authService.logOut.and.returnValue();
    fixture.detectChanges();
    expect(authService.logOut).toHaveBeenCalled();
  });


});
