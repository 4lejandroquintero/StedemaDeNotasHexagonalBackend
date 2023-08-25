import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PeliculasComponent } from './peliculas.component';
import { PeliculasService } from '@shared/services/pelicula/peliculas.service';
import { HttpService } from '@core/services/http.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { PeliculaComponent } from '../pelicula/pelicula.component';

describe('PeliculasComponent', () => {
  let component: PeliculasComponent;
  let fixture: ComponentFixture<PeliculasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PeliculasComponent, PeliculaComponent],
      imports: [HttpClientTestingModule],
      providers: [PeliculasService, HttpService]
    })
      .compileComponents();

    fixture = TestBed.createComponent(PeliculasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

});
