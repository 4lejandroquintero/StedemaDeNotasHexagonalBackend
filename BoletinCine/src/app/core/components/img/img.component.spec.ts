import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImgComponent } from './img.component';

describe('ImgComponent', () => {
  let component: ImgComponent;
  let fixture: ComponentFixture<ImgComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ImgComponent ]
    })
      .compileComponents();

    fixture = TestBed.createComponent(ImgComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    component.imgDefault = 'https://www.m2crowd.com/core/i/placeholder.png';
    expect(component).toBeTruthy();
  });

  it('no existe imagen', () => {
    component.noExistImg();
    component.imagen = 'https://www.m2crowd.com/core/i/placeholder.png';
    expect(component.imagen).toEqual(component.imgDefault);
  });




  it('deberia emitir imagen al padre', () => {
    component.imgLoaded();
    component.imagen = 'urlImagen';
    component.loaded.emit(component.imagen);
  });
});
