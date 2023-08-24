import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AsientosComponent } from './asientos.component';
import { BoletosService } from '@shared/services/boletos/boletos.service';
import { HttpService } from '@core/services/http.service';
import { AuthService } from '@core/services/auth.service';
import { AsientosService } from './service/asientos.service';
import { RouterTestingModule } from '@angular/router/testing';

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
});
