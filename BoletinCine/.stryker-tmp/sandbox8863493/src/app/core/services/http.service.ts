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
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
export interface Options {
  headers?: HttpHeaders;
  params?: HttpParams;
}
@Injectable()
export class HttpService {
  constructor(protected http: HttpClient) {}
  public createDefaultOptions(): Options {
    if (stryMutAct_9fa48("100")) {
      {}
    } else {
      stryCov_9fa48("100");
      return stryMutAct_9fa48("101") ? {} : (stryCov_9fa48("101"), {
        headers: new HttpHeaders(stryMutAct_9fa48("102") ? {} : (stryCov_9fa48("102"), {
          'Content-Type': stryMutAct_9fa48("103") ? "" : (stryCov_9fa48("103"), 'application/json')
        }))
      });
    }
  }
  public doGet<T>(serviceUrl: string, opts?: Options): Observable<T> {
    if (stryMutAct_9fa48("104")) {
      {}
    } else {
      stryCov_9fa48("104");
      const ropts = this.createOptions(opts);
      return this.http.get<T>(serviceUrl, ropts);
    }
  }
  public doPost<T, R>(serviceUrl: string, body: T, opts?: Options): Observable<R> {
    if (stryMutAct_9fa48("105")) {
      {}
    } else {
      stryCov_9fa48("105");
      const ropts = this.createOptions(opts);
      return this.http.post<R>(serviceUrl, body, ropts);
    }
  }
  public doDelete<R>(serviceUrl: string, opts?: Options): Observable<R> {
    if (stryMutAct_9fa48("106")) {
      {}
    } else {
      stryCov_9fa48("106");
      const ropts = this.createOptions(opts);
      return this.http.delete<R>(serviceUrl, ropts);
    }
  }
  public doGetParameters<T>(serviceUrl: string, parametros: HttpParams, opts?: Options): Observable<T> {
    if (stryMutAct_9fa48("107")) {
      {}
    } else {
      stryCov_9fa48("107");
      const ropts = this.createOptions(opts);
      const options = (stryMutAct_9fa48("110") ? parametros === null : stryMutAct_9fa48("109") ? false : stryMutAct_9fa48("108") ? true : (stryCov_9fa48("108", "109", "110"), parametros !== null)) ? ({
        headers: ropts.headers,
        params: parametros
      } as Options) : ropts;
      return this.http.get<T>(serviceUrl, options);
    }
  }
  public setHeader(name: string, value: string) {
    if (stryMutAct_9fa48("111")) {
      {}
    } else {
      stryCov_9fa48("111");
      const newopts = this.createDefaultOptions();
      newopts.headers = newopts.headers.set(name, value);
      return newopts;
    }
  }
  private createOptions(opts: Options): Options {
    if (stryMutAct_9fa48("112")) {
      {}
    } else {
      stryCov_9fa48("112");
      const defaultOpts: Options = this.createDefaultOptions();
      if (stryMutAct_9fa48("114") ? false : stryMutAct_9fa48("113") ? true : (stryCov_9fa48("113", "114"), opts)) {
        if (stryMutAct_9fa48("115")) {
          {}
        } else {
          stryCov_9fa48("115");
          opts = stryMutAct_9fa48("116") ? {} : (stryCov_9fa48("116"), {
            params: stryMutAct_9fa48("119") ? opts.params && defaultOpts.params : stryMutAct_9fa48("118") ? false : stryMutAct_9fa48("117") ? true : (stryCov_9fa48("117", "118", "119"), opts.params || defaultOpts.params),
            headers: stryMutAct_9fa48("122") ? opts.headers && defaultOpts.headers : stryMutAct_9fa48("121") ? false : stryMutAct_9fa48("120") ? true : (stryCov_9fa48("120", "121", "122"), opts.headers || defaultOpts.headers)
          });
          if (stryMutAct_9fa48("125") ? false : stryMutAct_9fa48("124") ? true : stryMutAct_9fa48("123") ? opts.headers.get('Content-Type') : (stryCov_9fa48("123", "124", "125"), !opts.headers.get(stryMutAct_9fa48("126") ? "" : (stryCov_9fa48("126"), 'Content-Type')))) {
            if (stryMutAct_9fa48("127")) {
              {}
            } else {
              stryCov_9fa48("127");
              opts.headers = opts.headers.set(stryMutAct_9fa48("128") ? "" : (stryCov_9fa48("128"), 'Content-Type'), defaultOpts.headers.get(stryMutAct_9fa48("129") ? "" : (stryCov_9fa48("129"), 'Content-Type')));
            }
          }
        }
      }
      return stryMutAct_9fa48("132") ? opts && defaultOpts : stryMutAct_9fa48("131") ? false : stryMutAct_9fa48("130") ? true : (stryCov_9fa48("130", "131", "132"), opts || defaultOpts);
    }
  }
}