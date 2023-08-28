// @ts-nocheck
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FuncionesComponent } from './funciones.component';
import { RouterTestingModule } from '@angular/router/testing';
import { FuncionesService } from '@shared/services/funcion/funciones.service';
import { HttpService } from '@core/services/http.service';


describe('FuncionesComponent', () => {
  let component: FuncionesComponent;
  let fixture: ComponentFixture<FuncionesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FuncionesComponent ],
      imports: [RouterTestingModule, HttpClientTestingModule],
      providers: [FuncionesService, HttpService]
    })
      .compileComponents();

    fixture = TestBed.createComponent(FuncionesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
