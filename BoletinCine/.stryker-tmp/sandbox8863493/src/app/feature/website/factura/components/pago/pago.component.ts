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
import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { PagoDTO } from '@shared/models/pago/pago';
@Component({
  selector: 'app-pago',
  templateUrl: './pago.component.html',
  styleUrls: ['./pago.component.scss']
})
export class PagoComponent implements OnInit {
  @Input()
  idFactura: number;
  @Input()
  valorTotalFactura: number;
  formPago: FormGroup;
  pago = new PagoDTO();
  idPago: string;
  valorAPagar: number;
  constructor(private pagosService: PagosService, private route: Router) {}
  ngOnInit(): void {
    if (stryMutAct_9fa48("227")) {
      {}
    } else {
      stryCov_9fa48("227");
      this.construirFormularioPago();
      this.pago.idFactura = this.idFactura;
    }
  }
  generarPago() {
    if (stryMutAct_9fa48("228")) {
      {}
    } else {
      stryCov_9fa48("228");
      this.valorAPagar = this.formPago.get(stryMutAct_9fa48("229") ? "" : (stryCov_9fa48("229"), 'valorAPagar')).value;
      if (stryMutAct_9fa48("233") ? this.valorAPagar >= this.valorTotalFactura : stryMutAct_9fa48("232") ? this.valorAPagar <= this.valorTotalFactura : stryMutAct_9fa48("231") ? false : stryMutAct_9fa48("230") ? true : (stryCov_9fa48("230", "231", "232", "233"), this.valorAPagar < this.valorTotalFactura)) {
        if (stryMutAct_9fa48("234")) {
          {}
        } else {
          stryCov_9fa48("234");
          return this.alertaError();
        }
      }
      return this.alertaConfirmacion().then(result => {
        if (stryMutAct_9fa48("235")) {
          {}
        } else {
          stryCov_9fa48("235");
          if (stryMutAct_9fa48("238") ? result.isConfirmed || this.formPago.valid : stryMutAct_9fa48("237") ? false : stryMutAct_9fa48("236") ? true : (stryCov_9fa48("236", "237", "238"), result.isConfirmed && this.formPago.valid)) {
            if (stryMutAct_9fa48("239")) {
              {}
            } else {
              stryCov_9fa48("239");
              this.pago.valorAPagar = this.formPago.get(stryMutAct_9fa48("240") ? "" : (stryCov_9fa48("240"), 'valorAPagar')).value;
              this.pagosService.crear(this.pago).subscribe(numeroPago => {
                if (stryMutAct_9fa48("241")) {
                  {}
                } else {
                  stryCov_9fa48("241");
                  this.idPago = numeroPago.valor.toString();
                  this.route.navigate(stryMutAct_9fa48("242") ? [] : (stryCov_9fa48("242"), [stryMutAct_9fa48("243") ? "" : (stryCov_9fa48("243"), '/comprobante/pago'), this.idPago]));
                }
              });
            }
          }
          return this.alertaPagoExitoso();
        }
      });
    }
  }
  alertaPagoExitoso() {
    if (stryMutAct_9fa48("244")) {
      {}
    } else {
      stryCov_9fa48("244");
      Swal.fire(stryMutAct_9fa48("245") ? "" : (stryCov_9fa48("245"), 'Pago realizado!'), stryMutAct_9fa48("246") ? "" : (stryCov_9fa48("246"), 'Se ha realizado el pago exitosamente'), stryMutAct_9fa48("247") ? "" : (stryCov_9fa48("247"), 'success'));
    }
  }
  alertaError() {
    if (stryMutAct_9fa48("248")) {
      {}
    } else {
      stryCov_9fa48("248");
      Swal.fire(stryMutAct_9fa48("249") ? {} : (stryCov_9fa48("249"), {
        icon: stryMutAct_9fa48("250") ? "" : (stryCov_9fa48("250"), 'error'),
        title: stryMutAct_9fa48("251") ? "" : (stryCov_9fa48("251"), 'Oops...'),
        text: stryMutAct_9fa48("252") ? "" : (stryCov_9fa48("252"), 'Has ingresado un valor menor al valor a pagar')
      }));
    }
  }
  alertaConfirmacion() {
    if (stryMutAct_9fa48("253")) {
      {}
    } else {
      stryCov_9fa48("253");
      return Swal.fire(stryMutAct_9fa48("254") ? {} : (stryCov_9fa48("254"), {
        title: stryMutAct_9fa48("255") ? "" : (stryCov_9fa48("255"), '¿Estás seguro?'),
        text: stryMutAct_9fa48("256") ? "" : (stryCov_9fa48("256"), 'Asegurate de ingresar correctamente los valores'),
        icon: stryMutAct_9fa48("257") ? "" : (stryCov_9fa48("257"), 'warning'),
        showCancelButton: stryMutAct_9fa48("258") ? false : (stryCov_9fa48("258"), true),
        cancelButtonColor: stryMutAct_9fa48("259") ? "" : (stryCov_9fa48("259"), '#d33'),
        confirmButtonColor: stryMutAct_9fa48("260") ? "" : (stryCov_9fa48("260"), '#3085d6'),
        confirmButtonText: stryMutAct_9fa48("261") ? "" : (stryCov_9fa48("261"), 'Yes!')
      }));
    }
  }
  private construirFormularioPago() {
    if (stryMutAct_9fa48("262")) {
      {}
    } else {
      stryCov_9fa48("262");
      this.formPago = new FormGroup(stryMutAct_9fa48("263") ? {} : (stryCov_9fa48("263"), {
        valorAPagar: new FormControl(stryMutAct_9fa48("264") ? "Stryker was here!" : (stryCov_9fa48("264"), ''), stryMutAct_9fa48("265") ? [] : (stryCov_9fa48("265"), [Validators.required]))
      }));
    }
  }
}