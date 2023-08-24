import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrearFuncionComponent } from './crear-funcion.component';

describe('CrearFuncionComponent', () => {
  let component: CrearFuncionComponent;
  let fixture: ComponentFixture<CrearFuncionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CrearFuncionComponent ]
    })
      .compileComponents();

    fixture = TestBed.createComponent(CrearFuncionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
