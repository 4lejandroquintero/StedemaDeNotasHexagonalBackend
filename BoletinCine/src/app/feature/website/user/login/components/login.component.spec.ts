import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginComponent } from './login.component';
import { AuthService } from '@core/services/auth.service';
import { HttpService } from '@core/services/http.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormBuilder } from '@angular/forms';
import Swal from 'sweetalert2';
import { of } from 'rxjs';

describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  let authService: AuthService;

  beforeEach(async () => {
    const spy = jasmine.createSpyObj('AuthService', ['loginAndGet']);
    await TestBed.configureTestingModule({
      declarations: [ LoginComponent ],
      imports: [HttpClientTestingModule],
      providers:[{AuthService, useValue: spy}, HttpService, FormBuilder, AuthService]
    })
      .compileComponents();

    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    authService = TestBed.inject(AuthService);
    spyOn(authService, 'loginAndGet').and.returnValue(of());
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  describe('metodos de alertas de login', ()=>{
    it('deberia aparecer alerta de inicion sesion correcto', () =>{
      const swalFireSpy = spyOn(Swal, 'fire');
      component.alertaInicionSesion();

      expect(swalFireSpy).toHaveBeenCalledWith({
        position: 'center',
        icon: 'success',
        title: 'Te has logueado con exito!',
        showConfirmButton: false,
        timer: 2000,
      }as any);
    });

    it('deberia aparecer alerta de inicion sesion incorrecto', () =>{
      const swalFireSpy = spyOn(Swal, 'fire');
      component.alertaSesionIncorrecta();

      expect(swalFireSpy).toHaveBeenCalledWith({
        icon: 'error',
        title: 'Oops...',
        text: 'Has ingresado incorrectamente el correo o contraseña.',
      }as any);
    });
  });


  it('should display incorrect session alert if form is not valid', () => {
    spyOn(component, 'alertaSesionIncorrecta'); // Spy on alertaSesionIncorrecta method
    component.iniciarSesion();
    expect(component.alertaSesionIncorrecta).toHaveBeenCalled();
  });

});
