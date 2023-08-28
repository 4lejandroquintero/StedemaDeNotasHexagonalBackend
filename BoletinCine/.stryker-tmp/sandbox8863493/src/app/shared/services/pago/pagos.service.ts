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
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpService } from '@core-service/http.service';
import { Pago, ValorRetornoPago, PagoDTO } from '@shared/models/pago/pago';
@Injectable({
  providedIn: 'root'
})
export class PagosService {
  private API_URL = stryMutAct_9fa48("386") ? `` : (stryCov_9fa48("386"), `${environment.endpoint}/pagos`);
  constructor(protected http: HttpService) {}
  crear(data: PagoDTO) {
    if (stryMutAct_9fa48("387")) {
      {}
    } else {
      stryCov_9fa48("387");
      return this.http.doPost<PagoDTO, ValorRetornoPago>(this.API_URL, data);
    }
  }
  obtenerPorID(id: string) {
    if (stryMutAct_9fa48("388")) {
      {}
    } else {
      stryCov_9fa48("388");
      return this.http.doGet<Pago>(stryMutAct_9fa48("389") ? `` : (stryCov_9fa48("389"), `${this.API_URL}/${id}`));
    }
  }
}