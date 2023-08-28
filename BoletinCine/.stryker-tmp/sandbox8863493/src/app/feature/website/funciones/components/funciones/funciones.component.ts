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
import { map, switchMap } from 'rxjs/operators';
import { Funcion } from '@models/funcion/funcion';
import { FuncionesService } from '@shared/services/funcion/funciones.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
@Component({
  selector: 'app-funciones',
  templateUrl: './funciones.component.html',
  styleUrls: ['./funciones.component.scss']
})
export class FuncionesComponent implements OnInit {
  funciones: Funcion[] = stryMutAct_9fa48("266") ? ["Stryker was here"] : (stryCov_9fa48("266"), []);
  idBoleto: number | null = null;
  longitudFunciones: number;
  constructor(private route: ActivatedRoute, private funcionesService: FuncionesService, private location: Location) {}
  ngOnInit(): void {
    if (stryMutAct_9fa48("267")) {
      {}
    } else {
      stryCov_9fa48("267");
      this.route.paramMap.pipe(switchMap(params => {
        if (stryMutAct_9fa48("268")) {
          {}
        } else {
          stryCov_9fa48("268");
          this.idBoleto = parseInt(params.get(stryMutAct_9fa48("269") ? "" : (stryCov_9fa48("269"), 'id')), 10);
          if (stryMutAct_9fa48("271") ? false : stryMutAct_9fa48("270") ? true : (stryCov_9fa48("270", "271"), this.idBoleto)) {
            if (stryMutAct_9fa48("272")) {
              {}
            } else {
              stryCov_9fa48("272");
              return this.funcionesService.obtenerListado().pipe(map(stryMutAct_9fa48("273") ? () => undefined : (stryCov_9fa48("273"), data => stryMutAct_9fa48("274") ? data : (stryCov_9fa48("274"), data.filter(stryMutAct_9fa48("275") ? () => undefined : (stryCov_9fa48("275"), funcion => stryMutAct_9fa48("278") ? parseInt(funcion.pelicula.idPelicula, 10) !== this.idBoleto : stryMutAct_9fa48("277") ? false : stryMutAct_9fa48("276") ? true : (stryCov_9fa48("276", "277", "278"), parseInt(funcion.pelicula.idPelicula, 10) === this.idBoleto)))))));
            }
          }
          return stryMutAct_9fa48("279") ? [] : (stryCov_9fa48("279"), [null]);
        }
      })).subscribe(data => {
        if (stryMutAct_9fa48("280")) {
          {}
        } else {
          stryCov_9fa48("280");
          this.funciones = data;
          this.longitudFunciones = this.funciones.length;
        }
      });
    }
  }
  volverAtras() {
    if (stryMutAct_9fa48("281")) {
      {}
    } else {
      stryCov_9fa48("281");
      this.location.back();
    }
  }
}