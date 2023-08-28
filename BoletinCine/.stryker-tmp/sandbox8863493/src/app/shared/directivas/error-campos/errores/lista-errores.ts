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
import { InjectionToken } from '@angular/core';
export const listaErrores = stryMutAct_9fa48("334") ? {} : (stryCov_9fa48("334"), {
  required: stryMutAct_9fa48("335") ? () => undefined : (stryCov_9fa48("335"), () => stryMutAct_9fa48("336") ? "" : (stryCov_9fa48("336"), 'Dato <strong> obligatorio </strong>')),
  min: stryMutAct_9fa48("337") ? () => undefined : (stryCov_9fa48("337"), ({
    min
  }) => stryMutAct_9fa48("338") ? `` : (stryCov_9fa48("338"), `Valor mínimo ${min}`)),
  max: stryMutAct_9fa48("339") ? () => undefined : (stryCov_9fa48("339"), ({
    max
  }) => stryMutAct_9fa48("340") ? `` : (stryCov_9fa48("340"), `Valor máximo ${max}`)),
  repetido: stryMutAct_9fa48("341") ? () => undefined : (stryCov_9fa48("341"), () => stryMutAct_9fa48("342") ? "" : (stryCov_9fa48("342"), 'Elemento repetido')),
  email: stryMutAct_9fa48("343") ? () => undefined : (stryCov_9fa48("343"), () => stryMutAct_9fa48("344") ? "" : (stryCov_9fa48("344"), 'Esto no es un correo')),
  minlength: stryMutAct_9fa48("345") ? () => undefined : (stryCov_9fa48("345"), ({
    requiredLength,
    actualLength
  }) => stryMutAct_9fa48("346") ? `` : (stryCov_9fa48("346"), `Mínimo <strong>${requiredLength}</strong> caracteres, actual <strong>${actualLength}</strong>`)),
  maxlength: stryMutAct_9fa48("347") ? () => undefined : (stryCov_9fa48("347"), ({
    requiredLength,
    actualLength
  }) => stryMutAct_9fa48("348") ? `` : (stryCov_9fa48("348"), `Máximo <strong>${requiredLength}</strong> caracteres, actual <strong>${actualLength}</strong>`))
});
export const FORM_ERRORS = new InjectionToken(stryMutAct_9fa48("349") ? "" : (stryCov_9fa48("349"), 'FORM_ERRORS'), stryMutAct_9fa48("350") ? {} : (stryCov_9fa48("350"), {
  providedIn: stryMutAct_9fa48("351") ? "" : (stryCov_9fa48("351"), 'root'),
  factory: stryMutAct_9fa48("352") ? () => undefined : (stryCov_9fa48("352"), () => listaErrores)
}));