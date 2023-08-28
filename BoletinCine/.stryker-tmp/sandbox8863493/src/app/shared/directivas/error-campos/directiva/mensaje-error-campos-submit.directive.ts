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
import { Directive, ElementRef } from '@angular/core';
import { fromEvent } from 'rxjs';
import { shareReplay, tap } from 'rxjs/operators';

/* eslint-disable @angular-eslint/directive-selector */
@Directive({
  selector: 'form'
})
export class MensajeErrorCamposSubmitDirective {
  public submit = fromEvent(this.element, stryMutAct_9fa48("324") ? "" : (stryCov_9fa48("324"), 'submit')).pipe(tap(() => {
    if (stryMutAct_9fa48("325")) {
      {}
    } else {
      stryCov_9fa48("325");
      if (stryMutAct_9fa48("328") ? this.element.classList.contains('submitted') !== false : stryMutAct_9fa48("327") ? false : stryMutAct_9fa48("326") ? true : (stryCov_9fa48("326", "327", "328"), this.element.classList.contains(stryMutAct_9fa48("329") ? "" : (stryCov_9fa48("329"), 'submitted')) === (stryMutAct_9fa48("330") ? true : (stryCov_9fa48("330"), false)))) {
        if (stryMutAct_9fa48("331")) {
          {}
        } else {
          stryCov_9fa48("331");
          this.element.classList.add(stryMutAct_9fa48("332") ? "" : (stryCov_9fa48("332"), 'submitted'));
        }
      }
    }
  }), shareReplay(1));
  constructor(private host: ElementRef<HTMLFormElement>) {}
  get element() {
    if (stryMutAct_9fa48("333")) {
      {}
    } else {
      stryCov_9fa48("333");
      return this.host.nativeElement;
    }
  }
}