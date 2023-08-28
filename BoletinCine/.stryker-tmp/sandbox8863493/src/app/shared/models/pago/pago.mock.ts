// @ts-nocheck
function stryNS_9fa48() {
  var g = new Function("return this")();
  var ns = g.__stryker__ || (g.__stryker__ = {});
  if (ns.activeMutant === undefined && g.process && g.process.env && g.process.env.__STRYKER_ACTIVE_MUTANT__) {
    ns.activeMutant = g.process.env.__STRYKER_ACTIVE_MUTANT__;
  }
  function retrieveNS() {
    return ns;
  }
  stryNS_9fa48 = retrieveNS;
  return retrieveNS();
}
stryNS_9fa48();
function stryCov_9fa48() {
  var ns = stryNS_9fa48();
  var cov = ns.mutantCoverage || (ns.mutantCoverage = {
    static: {},
    perTest: {}
  });
  function cover() {
    var c = cov.static;
    if (ns.currentTestId) {
      c = cov.perTest[ns.currentTestId] = cov.perTest[ns.currentTestId] || {};
    }
    var a = arguments;
    for (var i = 0; i < a.length; i++) {
      c[a[i]] = (c[a[i]] || 0) + 1;
    }
  }
  stryCov_9fa48 = cover;
  cover.apply(null, arguments);
}
function stryMutAct_9fa48(id) {
  var ns = stryNS_9fa48();
  function isActive(id) {
    if (ns.activeMutant === id) {
      if (ns.hitCount !== void 0 && ++ns.hitCount > ns.hitLimit) {
        throw new Error('Stryker: Hit count limit reached (' + ns.hitCount + ')');
      }
      return true;
    }
    return false;
  }
  stryMutAct_9fa48 = isActive;
  return isActive(id);
}
import { generateOneFactura } from '@shared/models/factura/factura.mock';
import { faker } from '@faker-js/faker';
export const generateOnePago = (): InfoPagoMock => {
  if (stryMutAct_9fa48("376")) {
    {}
  } else {
    stryCov_9fa48("376");
    return stryMutAct_9fa48("377") ? {} : (stryCov_9fa48("377"), {
      valorAPagar: faker.number.int(50000),
      devuelta: faker.number.int(50000),
      factura: generateOneFactura()
    });
  }
};
interface InfoPagoMock {
  valorAPagar: number;
  devuelta: number;
  factura: {
    idFactura: number;
    fechaFactura: string;
    estadoFactura: string;
    valorDeBoletos: number;
    descuento: number;
    valorTotal: number;
    cliente: {
      nombre: string;
      documentoIdentidad: string;
    };
    boleto: {
      idBoleto: number;
      cantidadAsientos: number;
      numeroAsientos: string;
      funcion: {
        salaFuncion: string;
        diaFuncion: string;
        horaFuncion: string;
        categoriaAudioFuncion: string;
        categoriaSubtitulosFuncion: string;
        categoriaVisualFuncion: string;
        pelicula: {
          nombrePelicula: string;
          sinopsisPelicula: string;
          imagenPortada: string;
          categoriaEdadPelicula: string;
        };
      };
    };
  };
}