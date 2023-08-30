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
    expect(component).toBeTruthy();
    expect(component.imgDefault).toBe('https://www.m2crowd.com/core/i/placeholder.png');
  });

  it('no existe imagen', () => {
    component.noExistImg();
    fixture.detectChanges();
    expect(component.imagen).toEqual(component.imgDefault);
  });

  it('deberia emitir imagen al padre', () => {
    const imgMock = 'https://www.m2crowd.com/core/i/placeholder.png';
    spyOn(component.loaded, 'emit');
    component.imagen =imgMock;

    component.imgLoaded();
    fixture.detectChanges();

    expect(component.loaded.emit).toHaveBeenCalledWith(imgMock);
  });
});
