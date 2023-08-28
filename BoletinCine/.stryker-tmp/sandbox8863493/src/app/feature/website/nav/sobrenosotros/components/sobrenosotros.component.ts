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
import { Component } from '@angular/core';
@Component({
  selector: 'app-sobrenosotros',
  templateUrl: './sobrenosotros.component.html',
  styleUrls: ['./sobrenosotros.component.scss']
})
export class SobrenosotrosComponent {
  imgs = stryMutAct_9fa48("286") ? [] : (stryCov_9fa48("286"), [stryMutAct_9fa48("287") ? "" : (stryCov_9fa48("287"), 'https://www.promotienda.es/wp-content/uploads/2023/04/cine.jpeg'), stryMutAct_9fa48("288") ? "" : (stryCov_9fa48("288"), 'https://ultimahoracol.com/wp-content/uploads/2020/08/arabia-saduita-cines.jpg.imgw_.1280.1280.jpeg'), stryMutAct_9fa48("289") ? "" : (stryCov_9fa48("289"), 'https://i.blogs.es/aa91a3/cine-/1366_2000.jpg')]);
}