import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComprobantePagoComponent } from './comprobante-pago.component';
import { PagosService } from '@shared/services/pago/pagos.service';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpService } from '@core/services/http.service';

describe('ComprobantePagoComponent', () => {
  let component: ComprobantePagoComponent;
  let fixture: ComponentFixture<ComprobantePagoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ComprobantePagoComponent ],
      imports: [RouterTestingModule, HttpClientTestingModule],
      providers: [PagosService, HttpService]
    })
      .compileComponents();

    fixture = TestBed.createComponent(ComprobantePagoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
