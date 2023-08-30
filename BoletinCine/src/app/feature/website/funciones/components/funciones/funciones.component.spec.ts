import { generateOneFuncion } from './../../../../../shared/models/funcion/funcion.mock';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FuncionesComponent } from './funciones.component';
import { RouterTestingModule } from '@angular/router/testing';
import { FuncionesService } from '@shared/services/funcion/funciones.service';
import { of } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { Funcion } from '@shared/models/funcion/funcion';


describe('FuncionesComponent', () => {
  let component: FuncionesComponent;
  let fixture: ComponentFixture<FuncionesComponent>;
  let mockFuncionesService: jasmine.SpyObj<FuncionesService>;
  const mockActivatedRoute = {
    paramMap: of({
      get: (param: string) => {
        if (param === 'id') {
          return '1';
        }
        return null;
      },
    }),
  };

  beforeEach(async () => {
    const funcionesServiceSpy = jasmine.createSpyObj(FuncionesService, ['obtenerListado']);

    await TestBed.configureTestingModule({
      declarations: [ FuncionesComponent ],
      imports: [RouterTestingModule, HttpClientTestingModule],
      providers: [Location,
        {provide: FuncionesService, useValue: funcionesServiceSpy},
        {provide: ActivatedRoute, useValue: mockActivatedRoute, ActivatedRoute},
      ]
    })
      .compileComponents();


    fixture = TestBed.createComponent(FuncionesComponent);
    component = fixture.componentInstance;
    mockFuncionesService = TestBed.inject(FuncionesService) as jasmine.SpyObj<FuncionesService>;

    expect(component.funciones).toEqual([]);
    const mockFunciones: Funcion[] =
    [
      {
        ...generateOneFuncion(),
        pelicula : {
          idPelicula: '1',
          nombrePelicula: 'deadpool',
          imagenPortada: 'imgUrl'
        }
      },
      {
        ...generateOneFuncion(),
        pelicula : {
          idPelicula: '1',
          nombrePelicula: 'deadpool 2',
          imagenPortada: 'imgUrl'
        }
      },
    ];
    mockFuncionesService.obtenerListado.and.returnValue(of(mockFunciones));

    fixture.detectChanges();
    expect(component.longitudFunciones).toBe(mockFunciones.length);
    expect(component.funciones).toEqual(mockFunciones);

  });

  it('should create', () => {
    component.ngOnInit();
    fixture.detectChanges();
    expect(component.idBoleto).toEqual(1);
    expect(component).toBeTruthy();
    expect(component.funciones.length).toEqual(2);
  });
});

describe('FuncionesComponent sin Token Inicial', () => {
  let component: FuncionesComponent;
  let fixture: ComponentFixture<FuncionesComponent>;
  let mockFuncionesService: jasmine.SpyObj<FuncionesService>;
  const mockActivatedRoute = {
    paramMap: of({
      get: (param: string) => {
        if (param === 'id') {
          return null;
        }
        return null;
      },
    }),
  };

  beforeEach(async () => {
    const funcionesServiceSpy = jasmine.createSpyObj(FuncionesService, ['obtenerListado']);

    await TestBed.configureTestingModule({
      declarations: [ FuncionesComponent ],
      imports: [RouterTestingModule, HttpClientTestingModule],
      providers: [Location,
        {provide: FuncionesService, useValue: funcionesServiceSpy},
        {provide: ActivatedRoute, useValue: mockActivatedRoute, ActivatedRoute},
      ]
    })
      .compileComponents();


    fixture = TestBed.createComponent(FuncionesComponent);
    component = fixture.componentInstance;
    mockFuncionesService = TestBed.inject(FuncionesService) as jasmine.SpyObj<FuncionesService>;

    expect(component.funciones).toEqual([]);
    expect(component.funciones.length).toEqual(0);
    const mockFunciones: Funcion[] =
    [
      {
        ...generateOneFuncion(),
        pelicula : {
          idPelicula: '1',
          nombrePelicula: 'deadpool',
          imagenPortada: 'imgUrl'
        }
      },
      {
        ...generateOneFuncion(),
        pelicula : {
          idPelicula: '1',
          nombrePelicula: 'deadpool 2',
          imagenPortada: 'imgUrl'
        }
      },
    ];
    mockFuncionesService.obtenerListado.and.returnValue(of(mockFunciones));

    fixture.detectChanges();

    expect(mockFuncionesService.obtenerListado).not.toHaveBeenCalled();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

});
