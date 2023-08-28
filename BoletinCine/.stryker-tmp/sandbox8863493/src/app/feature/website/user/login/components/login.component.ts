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
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '@core-service/auth.service';
import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  constructor(private authService: AuthService, private fb: FormBuilder) {
    if (stryMutAct_9fa48("290")) {
      {}
    } else {
      stryCov_9fa48("290");
      this.loginForm = this.fb.group({});
    }
  }
  ngOnInit(): void {
    if (stryMutAct_9fa48("291")) {
      {}
    } else {
      stryCov_9fa48("291");
      this.construirFormularioLogin();
    }
  }
  iniciarSesion() {
    if (stryMutAct_9fa48("292")) {
      {}
    } else {
      stryCov_9fa48("292");
      if (stryMutAct_9fa48("294") ? false : stryMutAct_9fa48("293") ? true : (stryCov_9fa48("293", "294"), this.loginForm.valid)) {
        if (stryMutAct_9fa48("295")) {
          {}
        } else {
          stryCov_9fa48("295");
          this.authService.loginAndGet(this.loginForm.get(stryMutAct_9fa48("296") ? "" : (stryCov_9fa48("296"), 'correo')).value, this.loginForm.get(stryMutAct_9fa48("297") ? "" : (stryCov_9fa48("297"), 'contrasena')).value).subscribe(() => {
            if (stryMutAct_9fa48("298")) {
              {}
            } else {
              stryCov_9fa48("298");
              this.alertaInicionSesion();
              this.recargarPagina();
            }
          });
        }
      }
      if (stryMutAct_9fa48("301") ? false : stryMutAct_9fa48("300") ? true : stryMutAct_9fa48("299") ? this.loginForm.valid : (stryCov_9fa48("299", "300", "301"), !this.loginForm.valid)) {
        if (stryMutAct_9fa48("302")) {
          {}
        } else {
          stryCov_9fa48("302");
          this.alertaSesionIncorrecta();
        }
      }
    }
  }
  recargarPagina() {
    if (stryMutAct_9fa48("303")) {
      {}
    } else {
      stryCov_9fa48("303");
      const tiempoEsperaAviso = 2000;
      setTimeout(function () {
        if (stryMutAct_9fa48("304")) {
          {}
        } else {
          stryCov_9fa48("304");
          window.location.reload();
        }
      }, tiempoEsperaAviso);
    }
  }
  alertaInicionSesion() {
    if (stryMutAct_9fa48("305")) {
      {}
    } else {
      stryCov_9fa48("305");
      const tiempoEsperaAviso = 2000;
      return Swal.fire(stryMutAct_9fa48("306") ? {} : (stryCov_9fa48("306"), {
        position: stryMutAct_9fa48("307") ? "" : (stryCov_9fa48("307"), 'center'),
        icon: stryMutAct_9fa48("308") ? "" : (stryCov_9fa48("308"), 'success'),
        title: stryMutAct_9fa48("309") ? "" : (stryCov_9fa48("309"), 'Te has logueado con exito!'),
        showConfirmButton: stryMutAct_9fa48("310") ? true : (stryCov_9fa48("310"), false),
        timer: tiempoEsperaAviso
      }));
    }
  }
  alertaSesionIncorrecta() {
    if (stryMutAct_9fa48("311")) {
      {}
    } else {
      stryCov_9fa48("311");
      return Swal.fire(stryMutAct_9fa48("312") ? {} : (stryCov_9fa48("312"), {
        icon: stryMutAct_9fa48("313") ? "" : (stryCov_9fa48("313"), 'error'),
        title: stryMutAct_9fa48("314") ? "" : (stryCov_9fa48("314"), 'Oops...'),
        text: stryMutAct_9fa48("315") ? "" : (stryCov_9fa48("315"), 'Has ingresado incorrectamente el correo o contraseña.')
      }));
    }
  }
  private construirFormularioLogin() {
    if (stryMutAct_9fa48("316")) {
      {}
    } else {
      stryCov_9fa48("316");
      this.loginForm = new FormGroup(stryMutAct_9fa48("317") ? {} : (stryCov_9fa48("317"), {
        correo: new FormControl(stryMutAct_9fa48("318") ? "Stryker was here!" : (stryCov_9fa48("318"), ''), stryMutAct_9fa48("319") ? [] : (stryCov_9fa48("319"), [Validators.required])),
        contrasena: new FormControl(stryMutAct_9fa48("320") ? "Stryker was here!" : (stryCov_9fa48("320"), ''), stryMutAct_9fa48("321") ? [] : (stryCov_9fa48("321"), [Validators.required]))
      }));
    }
  }
}