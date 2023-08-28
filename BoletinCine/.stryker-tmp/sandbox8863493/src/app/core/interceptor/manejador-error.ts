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
import { HttpErrorResponse } from '@angular/common/http';
import { ErrorHandler, Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { HTTP_ERRORES_CODIGO } from './http-codigo-error';
@Injectable()
export class ManejadorError implements ErrorHandler {
  handleError(error: string | Error): void {
    if (stryMutAct_9fa48("53")) {
      {}
    } else {
      stryCov_9fa48("53");
      const mensajeError = this.mensajePorDefecto(error);
      this.imprimirErrorConsola(mensajeError);
    }
  }
  private mensajePorDefecto(error) {
    if (stryMutAct_9fa48("54")) {
      {}
    } else {
      stryCov_9fa48("54");
      if (stryMutAct_9fa48("56") ? false : stryMutAct_9fa48("55") ? true : (stryCov_9fa48("55", "56"), error instanceof HttpErrorResponse)) {
        if (stryMutAct_9fa48("57")) {
          {}
        } else {
          stryCov_9fa48("57");
          if (stryMutAct_9fa48("60") ? false : stryMutAct_9fa48("59") ? true : stryMutAct_9fa48("58") ? navigator.onLine : (stryCov_9fa48("58", "59", "60"), !navigator.onLine)) {
            if (stryMutAct_9fa48("61")) {
              {}
            } else {
              stryCov_9fa48("61");
              return HTTP_ERRORES_CODIGO.NO_HAY_INTERNET;
            }
          }
          if (stryMutAct_9fa48("64") ? Object.prototype.hasOwnProperty.call(error, 'status') || !Object.prototype.hasOwnProperty.call(error.error, 'mensaje') : stryMutAct_9fa48("63") ? false : stryMutAct_9fa48("62") ? true : (stryCov_9fa48("62", "63", "64"), Object.prototype.hasOwnProperty.call(error, stryMutAct_9fa48("65") ? "" : (stryCov_9fa48("65"), 'status')) && (stryMutAct_9fa48("66") ? Object.prototype.hasOwnProperty.call(error.error, 'mensaje') : (stryCov_9fa48("66"), !Object.prototype.hasOwnProperty.call(error.error, stryMutAct_9fa48("67") ? "" : (stryCov_9fa48("67"), 'mensaje')))))) {
            if (stryMutAct_9fa48("68")) {
              {}
            } else {
              stryCov_9fa48("68");
              return this.obtenerErrorHttpCode(error.status);
            }
          }
        }
      }
      return error;
    }
  }
  private imprimirErrorConsola(mensaje): void {
    if (stryMutAct_9fa48("69")) {
      {}
    } else {
      stryCov_9fa48("69");
      const respuesta = stryMutAct_9fa48("70") ? {} : (stryCov_9fa48("70"), {
        fecha: new Date().toLocaleString(),
        path: window.location.href,
        mensaje
      });
      if (stryMutAct_9fa48("73") ? false : stryMutAct_9fa48("72") ? true : stryMutAct_9fa48("71") ? environment.production : (stryCov_9fa48("71", "72", "73"), !environment.production)) {
        if (stryMutAct_9fa48("74")) {
          {}
        } else {
          stryCov_9fa48("74");
          window.console.error(stryMutAct_9fa48("75") ? "" : (stryCov_9fa48("75"), 'Error inesperado:\n'), respuesta);
        }
      }
    }
  }
  private obtenerErrorHttpCode(httpCode: number): string {
    if (stryMutAct_9fa48("76")) {
      {}
    } else {
      stryCov_9fa48("76");
      if (stryMutAct_9fa48("78") ? false : stryMutAct_9fa48("77") ? true : (stryCov_9fa48("77", "78"), Object.prototype.hasOwnProperty.call(HTTP_ERRORES_CODIGO, httpCode))) {
        if (stryMutAct_9fa48("79")) {
          {}
        } else {
          stryCov_9fa48("79");
          return HTTP_ERRORES_CODIGO.PETICION_FALLIDA;
        }
      }
      return HTTP_ERRORES_CODIGO[httpCode];
    }
  }
}