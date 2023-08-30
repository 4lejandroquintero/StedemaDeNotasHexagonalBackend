import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SobrenosotrosComponent } from './sobrenosotros.component';

describe('SobrenosotrosComponent', () => {
  let component: SobrenosotrosComponent;
  let fixture: ComponentFixture<SobrenosotrosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SobrenosotrosComponent ]
    })
      .compileComponents();

    fixture = TestBed.createComponent(SobrenosotrosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('lista de imagenes correctas', () => {
    expect(component.imgs[0]).toBe('https://www.promotienda.es/wp-content/uploads/2023/04/cine.jpeg');
    expect(component.imgs[1]).toBe('https://ultimahoracol.com/wp-content/uploads/2020/08/arabia-saduita-cines.jpg.imgw_.1280.1280.jpeg');
    expect(component.imgs[2]).toBe('https://i.blogs.es/aa91a3/cine-/1366_2000.jpg');
  });
});
