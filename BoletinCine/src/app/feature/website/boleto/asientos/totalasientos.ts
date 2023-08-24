export function generarAsientos(){
  const asientos = [];

  for (let index = 1; index <= 8; index++) {
    const option = { asiento:`A${index}`, isTaken: false};
    asientos.push(option);
  }
  for (let index = 1; index <= 8; index++) {
    const option = { asiento:`B${index}`, isTaken: false};
    asientos.push(option);
  }
  for (let index = 1; index <= 8; index++) {
    const option = { asiento:`C${index}`, isTaken: false};
    asientos.push(option);
  }
  for (let index = 1; index <= 8; index++) {
    const option = { asiento:`D${index}`, isTaken: false};
    asientos.push(option);
  }
  for (let index = 1; index <= 8; index++) {
    const option = { asiento:`E${index}`, isTaken: false};
    asientos.push(option);
  }
  for (let index = 1; index <= 8; index++) {
    const option = { asiento:`F${index}`, isTaken: false};
    asientos.push(option);
  }
  for (let index = 1; index <= 8; index++) {
    const option = { asiento:`G${index}`, isTaken: false};
    asientos.push(option);
  }
  return asientos;
}

export interface Asiento{
  asiento: string;
  isTaken: boolean;
}
