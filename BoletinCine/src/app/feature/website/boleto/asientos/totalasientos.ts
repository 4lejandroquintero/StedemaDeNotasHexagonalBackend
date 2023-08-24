export function generarAsientos(){
  const asientos = [];
  const cantidadMaximaPorFila = 8;
  const letrasPorAsiento = ['A', 'B', 'C', 'D', 'E', 'F', 'G'];
  for (const letra of letrasPorAsiento) {
    for (let index = 1; index <= cantidadMaximaPorFila; index++) {
      const option = { asiento: `${letra}${index}`, isTaken: false };
      asientos.push(option);
    }
  }
  return asientos;
}

export interface Asiento{
  asiento: string;
  isTaken: boolean;
}
