import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { AppComponent } from './app.component';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { AuthService } from '@core/services/auth.service';
import { TokenService } from '@core/services/token.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { of } from 'rxjs';

describe('AppComponent', () => {
  let fixture: ComponentFixture<AppComponent>;

  let tokenService: jasmine.SpyObj<TokenService>;
  let authService: jasmine.SpyObj<AuthService>;
  beforeEach(waitForAsync(() => {
    const tokenServiceSpy = jasmine.createSpyObj('TokenService', ['getToken']);
    const authServiceSpy = jasmine.createSpyObj('AuthService', ['getProfile']);

    TestBed.configureTestingModule({
      declarations: [
        AppComponent
      ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
      imports: [HttpClientTestingModule],
      providers: [
        {provide: TokenService, useValue: tokenServiceSpy},
        {provide: AuthService, useValue: authServiceSpy}
      ]
    }).compileComponents();

    tokenService = TestBed.inject(TokenService) as jasmine.SpyObj<TokenService>;
    authService = TestBed.inject(AuthService) as jasmine.SpyObj<AuthService>;
  }));
  beforeEach(() => {
    tokenService.getToken.and.returnValue('token de Cliente');
    const clienteMock = {
      id: 1,
      nombre: 'Jose',
      email: 'jose@mail.com',
      contrasena: '123',
      documentoIdentidad: '12345',
      tipoMembresia: 'RUBY'
    };
    authService.getProfile.and.returnValue(of(clienteMock));

    fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
  });

  it('should create the app', () => {
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  });

});
