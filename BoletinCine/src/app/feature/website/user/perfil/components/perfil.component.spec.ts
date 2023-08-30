import { BehaviorSubject } from 'rxjs';
import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PerfilComponent } from './perfil.component';
import { AuthService } from '@core/services/auth.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';

describe('PerfilComponent', () => {
  let component: PerfilComponent;
  let fixture: ComponentFixture<PerfilComponent>;

  beforeEach(async () => {
    const clienteMock = {
      id: 1,
      nombre: 'Jose',
      email: 'jose@mail.com',
      contrasena: '123',
      documentoIdentidad: '1234',
      tipoMembresia: 'RUBY',
    };
    const authServicePrueba = {
      cliente$: new BehaviorSubject(clienteMock)
    };
    await TestBed.configureTestingModule({
      declarations: [ PerfilComponent ],
      imports: [HttpClientTestingModule],
      providers: [
        {provide: AuthService, useValue: authServicePrueba}
      ]
    })
      .compileComponents();

    fixture = TestBed.createComponent(PerfilComponent);
    component = fixture.componentInstance;


    fixture.detectChanges();
  });

  it('should create', () => {
    const clienteMock = {
      id: 1,
      nombre: 'Jose',
      email: 'jose@mail.com',
      contrasena: '123',
      documentoIdentidad: '1234',
      tipoMembresia: 'RUBY',
    };
    component.ngOnInit();
    fixture.detectChanges();

    expect(component.cliente).toEqual(clienteMock);
    expect(component).toBeTruthy();
  });
});
