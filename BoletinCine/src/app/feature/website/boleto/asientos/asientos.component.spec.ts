import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AsientosComponent } from './asientos.component';
import { BoletosService } from '@shared/services/boletos/boletos.service';
import { HttpService } from '@core/services/http.service';
import { AuthService } from '@core/services/auth.service';
import { AsientosService } from './service/asientos.service';
import { RouterTestingModule } from '@angular/router/testing';
import Swal from 'sweetalert2';

describe('AsientosComponent', () => {
  let component: AsientosComponent;
  let fixture: ComponentFixture<AsientosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AsientosComponent ],
      imports: [HttpClientTestingModule, RouterTestingModule],
      providers: [BoletosService, HttpService, AuthService, AsientosService]
    })
      .compileComponents();

    fixture = TestBed.createComponent(AsientosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('deberia aparecer alerta de inicion sesion correcto', () =>{
    const swalFireSpy = spyOn(Swal, 'fire');
    component.alertaExitosa();

    expect(swalFireSpy).toHaveBeenCalledWith({
      position: 'center',
      icon: 'success',
      title: 'Asientos confirmados exitosamente',
      showConfirmButton: false,
      timer: 1000
    }as any);
  });

  it('deberia cambiar valores binding', () => {
    component.cancelarConfirmacion();
    expect(component.cancelarAsientos).toEqual(true);
    expect(component.continuacionProceso).toEqual(true);
  });

  it('deberia cambiar valor asientos confirmados', () => {
    component.asientosSeleccionados = [[], []];
    expect(component.asientosConfirmados).toEqual(true);
  });
});
