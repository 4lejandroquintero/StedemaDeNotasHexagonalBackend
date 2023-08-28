/* eslint-disable @typescript-eslint/dot-notation */
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
import { ActivatedRoute } from '@angular/router';
import { BoletosService } from '@shared/services/boletos/boletos.service';
import { AsientosService } from './service/asientos.service';
import { Component, DoCheck, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { generarAsientos } from './totalasientos';
import { Funcion } from '@shared/models/funcion/funcion';
import Swal from 'sweetalert2';
import { BoletoDTO } from '@shared/models/boleto/boleto';
@Component({
  selector: 'app-asientos',
  templateUrl: './asientos.component.html',
  styleUrls: ['./asientos.component.scss']
})
export class AsientosComponent implements OnInit, DoCheck {
  @Input()
  funcion: Funcion;
  @Output()
  nombrePelicula = new EventEmitter<string>();
  asientosSeleccionados = stryMutAct_9fa48("144") ? ["Stryker was here"] : (stryCov_9fa48("144"), []);
  opcionesAsiento = stryMutAct_9fa48("145") ? ["Stryker was here"] : (stryCov_9fa48("145"), []);
  numAsientosSeleccionados = 0;
  boleto = new BoletoDTO();
  idFuncion: string | null = null;
  nombrePeli: string | null = null;
  asientosConfirmados = stryMutAct_9fa48("146") ? true : (stryCov_9fa48("146"), false);
  continuacionProceso = stryMutAct_9fa48("147") ? false : (stryCov_9fa48("147"), true);
  cancelarAsientos = stryMutAct_9fa48("148") ? false : (stryCov_9fa48("148"), true);
  valor: number;
  constructor(private boletosService: BoletosService, private asientosService: AsientosService, private route: ActivatedRoute) {
    if (stryMutAct_9fa48("149")) {
      {}
    } else {
      stryCov_9fa48("149");
      this.opcionesAsiento = generarAsientos();
    }
  }
  ngOnInit(): void {
    if (stryMutAct_9fa48("150")) {
      {}
    } else {
      stryCov_9fa48("150");
      this.route.paramMap.subscribe(params => {
        if (stryMutAct_9fa48("151")) {
          {}
        } else {
          stryCov_9fa48("151");
          this.idFuncion = params.get(stryMutAct_9fa48("152") ? "" : (stryCov_9fa48("152"), 'idFuncion'));
          this.nombrePeli = params.get(stryMutAct_9fa48("153") ? "" : (stryCov_9fa48("153"), 'nombrePeli'));
        }
      });
      this.valorNombrePelicula();
    }
  }
  ngDoCheck() {
    if (stryMutAct_9fa48("154")) {
      {}
    } else {
      stryCov_9fa48("154");
      if (stryMutAct_9fa48("157") ? this.asientosSeleccionados.length !== 0 : stryMutAct_9fa48("156") ? false : stryMutAct_9fa48("155") ? true : (stryCov_9fa48("155", "156", "157"), this.asientosSeleccionados.length === 0)) {
        if (stryMutAct_9fa48("158")) {
          {}
        } else {
          stryCov_9fa48("158");
          this.asientosConfirmados = stryMutAct_9fa48("159") ? false : (stryCov_9fa48("159"), true);
        }
      }
      if (stryMutAct_9fa48("163") ? this.asientosSeleccionados.length <= 0 : stryMutAct_9fa48("162") ? this.asientosSeleccionados.length >= 0 : stryMutAct_9fa48("161") ? false : stryMutAct_9fa48("160") ? true : (stryCov_9fa48("160", "161", "162", "163"), this.asientosSeleccionados.length > 0)) {
        if (stryMutAct_9fa48("164")) {
          {}
        } else {
          stryCov_9fa48("164");
          this.asientosConfirmados = stryMutAct_9fa48("165") ? true : (stryCov_9fa48("165"), false);
        }
      }
    }
  }
  valorNombrePelicula() {
    if (stryMutAct_9fa48("166")) {
      {}
    } else {
      stryCov_9fa48("166");
      this.nombrePelicula.emit(this.nombrePeli);
    }
  }
  obtenerAsientosSeleccionados(opcionesAsiento) {
    if (stryMutAct_9fa48("167")) {
      {}
    } else {
      stryCov_9fa48("167");
      this.asientosService.obtenerListaAsientos(opcionesAsiento);
    }
  }
  crearBoleto() {
    if (stryMutAct_9fa48("168")) {
      {}
    } else {
      stryCov_9fa48("168");
      this.boleto.idFuncion = parseInt(this.idFuncion, 10);
      this.boleto.cantidadAsientos = this.numAsientosSeleccionados;
      this.boleto.numeroAsientos = this.asientosSeleccionados.toString();
      this.boletosService.crear(this.boleto).subscribe(data => {
        if (stryMutAct_9fa48("169")) {
          {}
        } else {
          stryCov_9fa48("169");
          this.valor = data.valor;
          this.alertaExitosa();
        }
      });
      this.asientosConfirmados = stryMutAct_9fa48("170") ? false : (stryCov_9fa48("170"), true);
      this.cancelarAsientos = stryMutAct_9fa48("171") ? true : (stryCov_9fa48("171"), false);
      this.continuacionProceso = stryMutAct_9fa48("172") ? true : (stryCov_9fa48("172"), false);
    }
  }
  filtrarSeleccionados() {
    if (stryMutAct_9fa48("173")) {
      {}
    } else {
      stryCov_9fa48("173");
      this.asientosSeleccionados = stryMutAct_9fa48("174") ? this.opcionesAsiento.map(option => option.asiento) : (stryCov_9fa48("174"), this.opcionesAsiento.filter(stryMutAct_9fa48("175") ? () => undefined : (stryCov_9fa48("175"), option => option.isTaken)).map(stryMutAct_9fa48("176") ? () => undefined : (stryCov_9fa48("176"), option => option.asiento)));
      this.numAsientosSeleccionados = this.asientosSeleccionados.length;
      return this.asientosSeleccionados;
    }
  }
  cancelarConfirmacion() {
    if (stryMutAct_9fa48("177")) {
      {}
    } else {
      stryCov_9fa48("177");
      this.opcionesAsiento = generarAsientos();
      this.cancelarAsientos = stryMutAct_9fa48("178") ? false : (stryCov_9fa48("178"), true);
      this.continuacionProceso = stryMutAct_9fa48("179") ? false : (stryCov_9fa48("179"), true);
    }
  }
  alertaExitosa() {
    if (stryMutAct_9fa48("180")) {
      {}
    } else {
      stryCov_9fa48("180");
      return Swal.fire(stryMutAct_9fa48("181") ? {} : (stryCov_9fa48("181"), {
        position: stryMutAct_9fa48("182") ? "" : (stryCov_9fa48("182"), 'center'),
        icon: stryMutAct_9fa48("183") ? "" : (stryCov_9fa48("183"), 'success'),
        title: stryMutAct_9fa48("184") ? "" : (stryCov_9fa48("184"), 'Asientos confirmados exitosamente'),
        showConfirmButton: stryMutAct_9fa48("185") ? true : (stryCov_9fa48("185"), false),
        timer: 1000
      }));
    }
  }
}