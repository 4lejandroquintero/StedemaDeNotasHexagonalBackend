import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PeliculasComponent } from './peliculas.component';
import { PeliculasService } from '@shared/services/pelicula/peliculas.service';

import { HttpClientTestingModule } from '@angular/common/http/testing';
import { PeliculaComponent } from '../pelicula/pelicula.component';
import { of } from 'rxjs';

describe('PeliculasComponent', () => {
  let component: PeliculasComponent;
  let fixture: ComponentFixture<PeliculasComponent>;
  let peliculasService: jasmine.SpyObj<PeliculasService>;

  beforeEach(async () => {
    const peliculasServiceSpy = jasmine.createSpyObj('PeliculasService', ['obtenerListado']);
    await TestBed.configureTestingModule({
      declarations: [ PeliculasComponent, PeliculaComponent],
      imports: [HttpClientTestingModule],
      providers: [{provide: PeliculasService, useValue: peliculasServiceSpy}]
    })
      .compileComponents();

    fixture = TestBed.createComponent(PeliculasComponent);
    component = fixture.componentInstance;
    peliculasService = TestBed.inject(PeliculasService) as jasmine.SpyObj<PeliculasService>;
    const listaPeliculasMock = [
      {
        idPelicula: 1,
        nombrePelicula: 'Halo',
        sinopsisPelicula: 'Galactico',
        imagenPortada: 'imgUrl',
        categoriaEdadPelicula: '+14',
      },
      {
        idPelicula: 2,
        nombrePelicula: 'Halo 2',
        sinopsisPelicula: 'Galactico',
        imagenPortada: 'imgUrl',
        categoriaEdadPelicula: '+14',
      },
    ];
    expect(component.peliculas).toEqual([]);
    peliculasService.obtenerListado.and.returnValue(of(listaPeliculasMock));
    fixture.detectChanges();
  });

  it('should create', () => {

    const listaPeliculasMock = [
      {
        idPelicula: 1,
        nombrePelicula: 'Halo',
        sinopsisPelicula: 'Galactico',
        imagenPortada: 'imgUrl',
        categoriaEdadPelicula: '+14',
      },
      {
        idPelicula: 2,
        nombrePelicula: 'Halo 2',
        sinopsisPelicula: 'Galactico',
        imagenPortada: 'imgUrl',
        categoriaEdadPelicula: '+14',
      },
    ];
    peliculasService.obtenerListado.and.returnValue(of(listaPeliculasMock));
    component.ngOnInit();
    fixture.detectChanges();
    expect(peliculasService.obtenerListado).toHaveBeenCalled();
    expect(component).toBeTruthy();

  });

  it('deberia obtener lista de peliculas', () => {
    const listaPeliculasMock = [
      {
        idPelicula: 1,
        nombrePelicula: 'Halo',
        sinopsisPelicula: 'Galactico',
        imagenPortada: 'imgUrl',
        categoriaEdadPelicula: '+14',
      },
      {
        idPelicula: 2,
        nombrePelicula: 'Halo 2',
        sinopsisPelicula: 'Galactico',
        imagenPortada: 'imgUrl',
        categoriaEdadPelicula: '+14',
      },
    ];
    peliculasService.obtenerListado.and.returnValue(of(listaPeliculasMock));
    component.obtenerPeliculas();
    fixture.detectChanges();
    expect(component.peliculas).toEqual(listaPeliculasMock);
    expect(component.peliculas.length).toBe(2);
  });


});
