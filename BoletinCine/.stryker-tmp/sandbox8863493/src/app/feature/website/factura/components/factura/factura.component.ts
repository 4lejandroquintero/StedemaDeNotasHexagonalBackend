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
import { Factura } from './../../../../../shared/models/factura/factura';
import { ActivatedRoute } from '@angular/router';
import { FacturasService } from '@shared/services/factura/facturas.service';
import { Component, OnInit } from '@angular/core';
import { FacturaDTO } from '@shared/models/factura/factura';
import { TokenService } from '@core/services/token.service';
import { switchMap } from 'rxjs';
@Component({
  selector: 'app-factura',
  templateUrl: './factura.component.html',
  styleUrls: ['./factura.component.scss']
})
export class FacturaComponent implements OnInit {
  idBoleto: string | null;
  dataFactura = new FacturaDTO();
  factura: Factura;
  idFactura: number;
  factureishon: Factura;
  constructor(private facturaService: FacturasService, private route: ActivatedRoute, private tokenService: TokenService) {}
  ngOnInit(): void {
    if (stryMutAct_9fa48("218")) {
      {}
    } else {
      stryCov_9fa48("218");
      this.route.paramMap.pipe(switchMap(params => {
        if (stryMutAct_9fa48("219")) {
          {}
        } else {
          stryCov_9fa48("219");
          this.idBoleto = params.get(stryMutAct_9fa48("220") ? "" : (stryCov_9fa48("220"), 'idBoleto'));
          if (stryMutAct_9fa48("222") ? false : stryMutAct_9fa48("221") ? true : (stryCov_9fa48("221", "222"), this.idBoleto)) {
            if (stryMutAct_9fa48("223")) {
              {}
            } else {
              stryCov_9fa48("223");
              this.dataFactura.idBoleto = parseInt(this.idBoleto, 10);
              this.dataFactura.idCliente = parseInt(this.tokenService.getidCliente(), 10);
              return this.facturaService.crear(this.dataFactura);
            }
          }
          return stryMutAct_9fa48("224") ? ["Stryker was here"] : (stryCov_9fa48("224"), []);
        }
      })).subscribe(data => {
        if (stryMutAct_9fa48("225")) {
          {}
        } else {
          stryCov_9fa48("225");
          this.idFactura = data.valor;
          this.facturaService.obtenerPorID(this.idFactura).subscribe(valorFactura => {
            if (stryMutAct_9fa48("226")) {
              {}
            } else {
              stryCov_9fa48("226");
              this.factura = valorFactura;
            }
          });
        }
      });
    }
  }
}