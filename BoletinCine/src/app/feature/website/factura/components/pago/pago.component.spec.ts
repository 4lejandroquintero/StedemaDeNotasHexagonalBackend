import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { PagoComponent } from './pago.component';
import { PagosService } from '@shared/services/pago/pagos.service';
import { RouterTestingModule } from '@angular/router/testing';
import Swal from 'sweetalert2';
import { of } from 'rxjs';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';

describe('PagoComponent', () => {
  let component: PagoComponent;
  let fixture: ComponentFixture<PagoComponent>;
  let pagoService: jasmine.SpyObj<PagosService>;
  let route: jasmine.SpyObj<Router>;
  let formulario: jasmine.SpyObj<FormBuilder>;

  beforeEach(async () => {
    const pagoServiceSpy = jasmine.createSpyObj('PagosService', ['crear']);
    const routeSpy = jasmine.createSpyObj('Router', ['navigate']);
    const formularioSpy = jasmine.createSpyObj('FormBuilder', ['group']);
    await TestBed.configureTestingModule({
      declarations: [ PagoComponent ],
      imports: [RouterTestingModule, HttpClientTestingModule],
      providers: [
        {provide: PagosService, useValue: pagoServiceSpy},
        {provide: Router, useValue: routeSpy},
        {provide: FormBuilder, useValue: formularioSpy}
      ]
    })
      .compileComponents();

    fixture = TestBed.createComponent(PagoComponent);
    pagoService = TestBed.inject(PagosService) as jasmine.SpyObj<PagosService>;
    formulario = TestBed.inject(FormBuilder) as jasmine.SpyObj<FormBuilder>;
    route = TestBed.inject(Router) as jasmine.SpyObj<Router>;
    component = fixture.componentInstance;
    const mockFormGroup: FormGroup = new FormBuilder().group({
      valorAPagar: 3000,
    });

    formulario.group.and.returnValue(mockFormGroup);


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

  it('deberia generar pago incorrectamente y lanzar alerta error', ()=>{
    component.formPago.get('valorAPagar').setValue(3000);
    component.valorTotalFactura = 4000;
    component.formPago.markAsDirty();
    spyOn(component, 'alertaError');
    component.generarPago();
    fixture.detectChanges();

    expect(component.valorAPagar).toEqual(3000);
    expect(component.alertaError).toHaveBeenCalled();
  });

  it('deberia generar pago exitosamente', fakeAsync(()=>{
    component.formPago.get('valorAPagar').setValue(3000);
    component.formPago.markAsDirty();
    component.valorTotalFactura = 2000;


    spyOn(component, 'alertaConfirmacion').and.returnValue(Promise.resolve({ isConfirmed: true } as any));
    spyOn(component, 'alertaPagoExitoso');

    pagoService.crear.and.returnValue(of({valor:123}));
    route.navigate.and.returnValue(of(true) as any);

    component.generarPago();
    tick();
    fixture.detectChanges();

    expect(component.idPago).toEqual('123');
    expect(route.navigate).toHaveBeenCalledWith(['/comprobante/pago','123']);
    expect(component.pago.valorAPagar).toEqual(3000);
    expect(pagoService.crear).toHaveBeenCalled();
    expect(component.alertaPagoExitoso).toHaveBeenCalled();
  }));

  it('deberia generar pago exitosamente con el valor igual al que paga', fakeAsync(()=>{
    component.formPago.get('valorAPagar').setValue(2000);
    component.formPago.markAsDirty();
    component.valorTotalFactura = 2000;


    spyOn(component, 'alertaConfirmacion').and.returnValue(Promise.resolve({ isConfirmed: true } as any));
    spyOn(component, 'alertaPagoExitoso');

    pagoService.crear.and.returnValue(of({valor:123}));
    route.navigate.and.returnValue(of(true) as any);

    component.generarPago();
    tick();
    fixture.detectChanges();

    expect(component.pago.valorAPagar).toEqual(2000);
    expect(component.valorTotalFactura).toEqual(component.valorAPagar);
    expect(pagoService.crear).toHaveBeenCalled();
    expect(component.alertaPagoExitoso).toHaveBeenCalled();
  }));

  it('deberia generar pago incorrecto y no hacer nada', fakeAsync(()=>{
    component.formPago.get('valorAPagar').setValue(3000);
    component.formPago.markAsDirty();
    component.valorTotalFactura = 2000;


    spyOn(component, 'alertaConfirmacion').and.returnValue(Promise.resolve({ isConfirmed: false } as any));
    spyOn(component, 'alertaPagoExitoso');

    pagoService.crear.and.returnValue(of({valor:123}));
    route.navigate.and.returnValue(of(true) as any);

    component.generarPago();
    tick();
    fixture.detectChanges();

    expect(pagoService.crear).not.toHaveBeenCalled();
  }));
});
