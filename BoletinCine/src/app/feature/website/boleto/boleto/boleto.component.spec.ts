import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoletoComponent } from './boleto.component';
import { AsientosService } from '../asientos/service/asientos.service';

describe('BoletoComponent', () => {
  let component: BoletoComponent;
  let fixture: ComponentFixture<BoletoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoletoComponent ],
      providers: [AsientosService]
    })
      .compileComponents();

    fixture = TestBed.createComponent(BoletoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
