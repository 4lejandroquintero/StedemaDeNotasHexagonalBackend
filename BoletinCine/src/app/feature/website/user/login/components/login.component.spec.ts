import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginComponent } from './login.component';
import { AuthService } from '@core/services/auth.service';
import { HttpService } from '@core/services/http.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import Swal from 'sweetalert2';
import { of } from 'rxjs';

describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  let authService: jasmine.SpyObj<AuthService> ;


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
    authService = TestBed.inject(AuthService) as jasmine.SpyObj<AuthService>;
    spyOn(authService, 'loginAndGet').and.returnValue(of());

    fixture.detectChanges();
  });

  it('should create', () => {
    spyOn(component, 'construirFormularioLogin');

    fixture.detectChanges();
    component.ngOnInit();

    expect(component.construirFormularioLogin).toHaveBeenCalled();
    expect(component).toBeTruthy();
  });

  describe('metodos de alertas de login', ()=>{
    it('deberia aparecer alerta de inicion sesion correcto', () =>{
      const loginFormMock = new FormGroup({
        correo: new FormControl('', [Validators.required]),
        contrasena: new FormControl('', [Validators.required]),
      });

      component.loginForm = loginFormMock;
      component.iniciarSesion();
      fixture.detectChanges();
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
      const loginFormMock = new FormGroup({
        correo: new FormControl('', [Validators.required]),
        contrasena: new FormControl('', [Validators.required]),
      });

      const swalFireSpy = spyOn(Swal, 'fire');
      component.loginForm = loginFormMock;
      component.iniciarSesion();

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

  it('deberia construir formulario login', () => {
    component.construirFormularioLogin();
    const loginFormMock = new FormGroup({
      correo: new FormControl('', [Validators.required]),
      contrasena: new FormControl('', [Validators.required]),
    });
    component.loginForm = loginFormMock;
    expect(component.loginForm.get('correo').hasError('required')).toBeTruthy();
    expect(component.loginForm.get('contrasena').hasError('required')).toBeTruthy();
  });
  it('validar validators login', ()=>{

    component.loginForm.get('correo').setValue('');
    component.loginForm.get('contrasena').setValue('');
    component.construirFormularioLogin();

    const correoControl = component.loginForm.get('correo');
    const contrasenaControl = component.loginForm.get('contrasena');

    expect(correoControl).toBeDefined();
    expect(correoControl).toBeInstanceOf(FormControl);
    expect(correoControl.hasError('required')).toBe(true);

    expect(contrasenaControl).toBeDefined();
    expect(contrasenaControl).toBeInstanceOf(FormControl);
    expect(contrasenaControl.hasError('required')).toBe(true);

  });

  describe('test de alertas', () => {
    it('deberia retornar alerta de inicio de sesion correcta', () => {
      const espiaAlerta = spyOn(Swal, 'fire');
      component.alertaInicionSesion();
      fixture.detectChanges();

      expect(espiaAlerta).toHaveBeenCalledWith({
        position: 'center',
        icon: 'success',
        title: 'Te has logueado con exito!',
        showConfirmButton: false,
        timer: 2000,
      } as any);
    });

    it('deberia retornar alerta de inicio de incorrecta', () => {
      const espiaAlerta = spyOn(Swal, 'fire');
      component.alertaSesionIncorrecta();
      fixture.detectChanges();

      expect(espiaAlerta).toHaveBeenCalledWith({
        icon: 'error',
        title: 'Oops...',
        text: 'Has ingresado incorrectamente el correo o contraseña.',
      }as any);
    });
  });

  describe('test inicar sesion', ()=>{
    it('deberia iniciar sesion correctamente', ()=>{
      const alertaInicionSesionSpy = spyOn(component, 'alertaInicionSesion');
      const recargarPaginaSpy = spyOn(component, 'recargarPagina');
      const clienteMock = {
        id: 1,
        nombre: 'Jose',
        email: 'jose@mail.com',
        contrasena: '123',
        documentoIdentidad: '1234',
        tipoMembresia: 'RUBY',
      };
      const espia = authService.loginAndGet.and.returnValue(of(clienteMock));

      component.loginForm.get('correo').setValue('jose@mail.com');
      component.loginForm.get('contrasena').setValue('123');
      component.loginForm.markAsDirty();

      component.iniciarSesion();
      fixture.detectChanges();
      expect(espia).toHaveBeenCalled();
      expect(alertaInicionSesionSpy).toHaveBeenCalled();
      expect(recargarPaginaSpy).toHaveBeenCalled();
    });
    it('deberia iniciar sesion correctamente', ()=>{
      const alertaSesionIncorrecta = spyOn(component, 'alertaSesionIncorrecta');
      const clienteMock = {
        id: 1,
        nombre: 'Jose',
        email: 'jose@mail.com',
        contrasena: '123',
        documentoIdentidad: '1234',
        tipoMembresia: 'RUBY',
      };
      const espia = authService.loginAndGet.and.returnValue(of(clienteMock));


      component.iniciarSesion();
      fixture.detectChanges();
      expect(espia).not.toHaveBeenCalled();
      expect(alertaSesionIncorrecta).toHaveBeenCalled();
    });
  });
});
