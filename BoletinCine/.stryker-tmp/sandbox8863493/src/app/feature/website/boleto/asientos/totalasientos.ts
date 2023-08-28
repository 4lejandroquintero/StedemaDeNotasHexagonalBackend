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
export function generarAsientos() {
  if (stryMutAct_9fa48("191")) {
    {}
  } else {
    stryCov_9fa48("191");
    const asientos = stryMutAct_9fa48("192") ? ["Stryker was here"] : (stryCov_9fa48("192"), []);
    const cantidadMaximaPorFila = 8;
    const letrasPorAsiento = stryMutAct_9fa48("193") ? [] : (stryCov_9fa48("193"), [stryMutAct_9fa48("194") ? "" : (stryCov_9fa48("194"), 'A'), stryMutAct_9fa48("195") ? "" : (stryCov_9fa48("195"), 'B'), stryMutAct_9fa48("196") ? "" : (stryCov_9fa48("196"), 'C'), stryMutAct_9fa48("197") ? "" : (stryCov_9fa48("197"), 'D'), stryMutAct_9fa48("198") ? "" : (stryCov_9fa48("198"), 'E'), stryMutAct_9fa48("199") ? "" : (stryCov_9fa48("199"), 'F'), stryMutAct_9fa48("200") ? "" : (stryCov_9fa48("200"), 'G')]);
    for (const letra of letrasPorAsiento) {
      if (stryMutAct_9fa48("201")) {
        {}
      } else {
        stryCov_9fa48("201");
        for (let index = 1; stryMutAct_9fa48("204") ? index > cantidadMaximaPorFila : stryMutAct_9fa48("203") ? index < cantidadMaximaPorFila : stryMutAct_9fa48("202") ? false : (stryCov_9fa48("202", "203", "204"), index <= cantidadMaximaPorFila); stryMutAct_9fa48("205") ? index-- : (stryCov_9fa48("205"), index++)) {
          if (stryMutAct_9fa48("206")) {
            {}
          } else {
            stryCov_9fa48("206");
            const option = stryMutAct_9fa48("207") ? {} : (stryCov_9fa48("207"), {
              asiento: stryMutAct_9fa48("208") ? `` : (stryCov_9fa48("208"), `${letra}${index}`),
              isTaken: stryMutAct_9fa48("209") ? true : (stryCov_9fa48("209"), false)
            });
            asientos.push(option);
          }
        }
      }
    }
    return asientos;
  }
}
export interface Asiento {
  asiento: string;
  isTaken: boolean;
}