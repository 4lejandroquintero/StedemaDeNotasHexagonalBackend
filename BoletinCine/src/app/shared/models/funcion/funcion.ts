export interface Funcion{
  idFuncion: number;
  pelicula: {
    idPelicula: string;
    nombrePelicula: string;
    imagenPortada: string;
  };
  nombreTeatro: string;
  salaFuncion: string;
  diaFuncion: string;
  horaFuncion: string;
  valorFuncion: number;
  categoriaAudioFuncion: string;
  categoriaSubtitulosFuncion: string;
  categoriaVisualFuncion: string;
}
