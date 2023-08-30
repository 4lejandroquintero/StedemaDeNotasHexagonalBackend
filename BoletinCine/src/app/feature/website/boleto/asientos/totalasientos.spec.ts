import { generarAsientos } from './totalasientos';

describe('generarAsientos', () => {
  it('debería generar la lista de asientos correctamente', () => {
    const asientosGenerados = generarAsientos();

    expect(asientosGenerados.length).toBe(56); // 7 filas x 8 asientos por fila

    const letrasPorAsiento = ['A', 'B', 'C', 'D', 'E', 'F', 'G'];
    let asientoContador = 1;
    for (const letra of letrasPorAsiento) {
      for (let index = 1; index <= 8; index++) {
        const asientoEsperado = `${letra}${index}`;
        const asientoGenerado = asientosGenerados[asientoContador - 1];

        expect(asientoGenerado.asiento).toBe(asientoEsperado);
        expect(asientoGenerado.isTaken).toBe(false);

        asientoContador++;
      }
    }
  });
});
