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
import { PagosService } from '@shared/services/pago/pagos.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Pago } from '@shared/models/pago/pago';
@Component({
  selector: 'app-comprobante-pago',
  templateUrl: './comprobante-pago.component.html',
  styleUrls: ['./comprobante-pago.component.scss']
})
export class ComprobantePagoComponent implements OnInit {
  idPago: string;
  pago: Pago;
  constructor(private route: ActivatedRoute, private pagosService: PagosService) {}
  ngOnInit(): void {
    if (stryMutAct_9fa48("214")) {
      {}
    } else {
      stryCov_9fa48("214");
      this.route.paramMap.subscribe(stryMutAct_9fa48("215") ? () => undefined : (stryCov_9fa48("215"), data => this.idPago = data.get(stryMutAct_9fa48("216") ? "" : (stryCov_9fa48("216"), 'idPago'))));
      this.pagosService.obtenerPorID(this.idPago).subscribe(data => {
        if (stryMutAct_9fa48("217")) {
          {}
        } else {
          stryCov_9fa48("217");
          this.pago = data;
        }
      });
    }
  }
}