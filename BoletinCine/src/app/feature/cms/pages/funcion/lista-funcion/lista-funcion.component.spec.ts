import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaFuncionComponent } from './lista-funcion.component';

describe('ListaFuncionComponent', () => {
  let component: ListaFuncionComponent;
  let fixture: ComponentFixture<ListaFuncionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListaFuncionComponent ]
    })
      .compileComponents();

    fixture = TestBed.createComponent(ListaFuncionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
