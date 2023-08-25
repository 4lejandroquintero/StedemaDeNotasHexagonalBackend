import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { PagoComponent } from './pago.component';
import { PagosService } from '@shared/services/pago/pagos.service';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpService } from '@core/services/http.service';
import Swal from 'sweetalert2';

describe('PagoComponent', () => {
  let component: PagoComponent;
  let fixture: ComponentFixture<PagoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PagoComponent ],
      imports: [RouterTestingModule, HttpClientTestingModule],
      providers: [PagosService, HttpService]
    })
      .compileComponents();

    fixture = TestBed.createComponent(PagoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('deberia aparecer alerta de pago exitoso', () =>{
    const swalFireSpy = spyOn(Swal, 'fire');
    component.alertaPagoExitoso();

    expect(swalFireSpy).toHaveBeenCalledWith(
      'Pago realizado!',
      'Se ha realizado el pago exitosamente',
      'success'
    );
  });

  it('deberia aparecer alerta de confirmacion', () =>{
    const swalFireSpy = spyOn(Swal, 'fire');
    component.alertaConfirmacion();

    expect(swalFireSpy).toHaveBeenCalledWith({
      title: '¿Estás seguro?',
      text: 'Asegurate de ingresar correctamente los valores',
      icon: 'warning',
      showCancelButton: true,
      cancelButtonColor: '#d33',
      confirmButtonColor: '#3085d6',
      confirmButtonText: 'Yes!'
    }as any);
  });

  it('deberia aparecer alerta de error', () =>{
    const swalFireSpy = spyOn(Swal, 'fire');
    component.alertaError();

    expect(swalFireSpy).toHaveBeenCalledWith({
      icon: 'error',
      title: 'Oops...',
      text: 'Has ingresado un valor menor al valor a pagar',
    }as any);
  });


  it('should display error alert if valorAPagar is less than valorTotalFactura', () => {
    const swalFireSpy = spyOn(Swal, 'fire');

    component.valorTotalFactura = 100;
    component.formPago.patchValue({ valorAPagar: 50 });
    component.generarPago();
    expect(swalFireSpy).toHaveBeenCalledWith(({
      icon: 'error',
      title: 'Oops...',
      text: 'Has ingresado un valor menor al valor a pagar',
    }) as any);
  });
});
