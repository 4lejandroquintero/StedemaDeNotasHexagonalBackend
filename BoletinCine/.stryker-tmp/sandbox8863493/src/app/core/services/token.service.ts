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
@Injectable({
  providedIn: 'root'
})
export class TokenService {
  constructor() {}
  saveToken(token: string) {
    if (stryMutAct_9fa48("133")) {
      {}
    } else {
      stryCov_9fa48("133");
      localStorage.setItem(stryMutAct_9fa48("134") ? "" : (stryCov_9fa48("134"), 'token'), token);
    }
  }
  getToken() {
    if (stryMutAct_9fa48("135")) {
      {}
    } else {
      stryCov_9fa48("135");
      return localStorage.getItem(stryMutAct_9fa48("136") ? "" : (stryCov_9fa48("136"), 'token'));
    }
  }
  saveIdUser(idCliente: string) {
    if (stryMutAct_9fa48("137")) {
      {}
    } else {
      stryCov_9fa48("137");
      localStorage.setItem(stryMutAct_9fa48("138") ? "" : (stryCov_9fa48("138"), 'idCliente'), idCliente);
    }
  }
  public getidCliente() {
    if (stryMutAct_9fa48("139")) {
      {}
    } else {
      stryCov_9fa48("139");
      return localStorage.getItem(stryMutAct_9fa48("140") ? "" : (stryCov_9fa48("140"), 'idCliente'));
    }
  }
  borrarDatos() {
    if (stryMutAct_9fa48("141")) {
      {}
    } else {
      stryCov_9fa48("141");
      localStorage.removeItem(stryMutAct_9fa48("142") ? "" : (stryCov_9fa48("142"), 'token'));
      localStorage.removeItem(stryMutAct_9fa48("143") ? "" : (stryCov_9fa48("143"), 'idCliente'));
    }
  }
}