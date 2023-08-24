import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PagoComponent } from './pago.component';
import { PagosService } from '@shared/services/pago/pagos.service';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpService } from '@core/services/http.service';

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
});
