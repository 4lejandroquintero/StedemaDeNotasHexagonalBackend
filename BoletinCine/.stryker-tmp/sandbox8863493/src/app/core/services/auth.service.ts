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
import { Cliente } from '@models/cliente/cliente';
import { tap, switchMap } from 'rxjs/operators';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpService } from './http.service';
import { TokenService } from './token.service';
import { Auth } from '@core/modelo/authprofile';
import { BehaviorSubject } from 'rxjs';
interface ComandoLogin {
  correo: string;
  contrasena: string;
}
@Injectable()
export class AuthService {
  public dataCliente: Cliente | null = null;
  public cliente = new BehaviorSubject<Cliente | null>(null);
  // eslint-disable-next-line @typescript-eslint/member-ordering
  public cliente$ = this.cliente.asObservable();
  private API_URL = stryMutAct_9fa48("88") ? `` : (stryCov_9fa48("88"), `${environment.endpoint}/cliente`);
  constructor(private http: HttpService, private tokenService: TokenService) {}
  login(correo: string, contrasena: string) {
    if (stryMutAct_9fa48("89")) {
      {}
    } else {
      stryCov_9fa48("89");
      return this.http.doPost<ComandoLogin, Auth>(stryMutAct_9fa48("90") ? `` : (stryCov_9fa48("90"), `${this.API_URL}/login`), stryMutAct_9fa48("91") ? {} : (stryCov_9fa48("91"), {
        correo,
        contrasena
      })).pipe(tap(response => {
        if (stryMutAct_9fa48("92")) {
          {}
        } else {
          stryCov_9fa48("92");
          this.tokenService.saveToken(response.valor.token);
          this.tokenService.saveIdUser(response.valor.idCliente.toString());
        }
      }));
    }
  }
  loginAndGet(correo: string, contrasena: string) {
    if (stryMutAct_9fa48("93")) {
      {}
    } else {
      stryCov_9fa48("93");
      return this.login(correo, contrasena).pipe(switchMap(stryMutAct_9fa48("94") ? () => undefined : (stryCov_9fa48("94"), () => this.getProfile())));
    }
  }
  logOut() {
    if (stryMutAct_9fa48("95")) {
      {}
    } else {
      stryCov_9fa48("95");
      this.tokenService.borrarDatos();
      this.cliente = null;
    }
  }
  getProfile() {
    if (stryMutAct_9fa48("96")) {
      {}
    } else {
      stryCov_9fa48("96");
      return this.http.doGet<Cliente>(stryMutAct_9fa48("97") ? `` : (stryCov_9fa48("97"), `${this.API_URL}/full/${this.tokenService.getidCliente()}`)).pipe(tap(stryMutAct_9fa48("98") ? () => undefined : (stryCov_9fa48("98"), user => this.setCliente(user))));
    }
  }
  setCliente(u: Cliente) {
    if (stryMutAct_9fa48("99")) {
      {}
    } else {
      stryCov_9fa48("99");
      this.dataCliente = u;
      this.cliente.next(this.dataCliente);
    }
  }
}