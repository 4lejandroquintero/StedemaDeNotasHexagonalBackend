import { BootstrapmaterialModule } from '@shared/bootstrapmaterial/bootstrapmaterial.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { MensajeErrorCamposSubmitDirective } from './directivas/error-campos/directiva/mensaje-error-campos-submit.directive';
import { MensajeErrorCamposContenedorDirective } from './directivas/error-campos/directiva/mensaje-error-campos-contenedor.directive';
import { ErrorCamposPlantillaComponent } from './directivas/error-campos/componente/error-campos-plantilla.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { TrackByPipe } from './pipe/track-by.pipe';
import { AngularmaterialModule } from './angularmaterial/angularmaterial.module';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { MatTableModule } from '@angular/material/table';
import { SwiperModule } from 'swiper/angular';
import { PeliculasService } from './services/pelicula/peliculas.service';
import { FuncionesService } from './services/funcion/funciones.service';


@NgModule({
  declarations: [
    ErrorCamposPlantillaComponent,
    MensajeErrorCamposContenedorDirective,
    MensajeErrorCamposSubmitDirective,
    TrackByPipe,
  ],
  imports: [ReactiveFormsModule, FormsModule, BootstrapmaterialModule,  ],
  exports: [
    CommonModule,
    HttpClientModule,
    MensajeErrorCamposContenedorDirective,
    MensajeErrorCamposSubmitDirective,
    ReactiveFormsModule,
    FormsModule,
    TrackByPipe,
    BootstrapmaterialModule,
    AngularmaterialModule,
    MatTableModule,
    MatSelectModule,
    MatFormFieldModule,
    SwiperModule,
  ],
  providers:[PeliculasService, FuncionesService]
})
export class SharedModule { }
