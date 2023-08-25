import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '@core-service/auth.service';
import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit{

  loginForm: FormGroup;
  tiempoEsperaAviso = 2000;

  constructor(
    private authService: AuthService,
    private fb: FormBuilder,
  ) {this.loginForm = this.fb.group({});}

  ngOnInit(): void {
    this.construirFormularioLogin();
  }


  iniciarSesion(){
    if(this.loginForm.valid){
      this.authService.loginAndGet(this.loginForm.get('correo').value, this.loginForm.get('contrasena').value )
        .subscribe(()=>{
          this.alertaInicionSesion();
          this.recargarPagina();
        });
    }
    if(!this.loginForm.valid){
      this.alertaSesionIncorrecta();
    }
  }

  recargarPagina(){
    setTimeout(function() {
      window.location.reload();
    }, this.tiempoEsperaAviso);
  }

  alertaInicionSesion(){
    return Swal.fire({
      position: 'center',
      icon: 'success',
      title: 'Te has logueado con exito!',
      showConfirmButton: false,
      timer: this.tiempoEsperaAviso,
    });
  }
  alertaSesionIncorrecta(){
    return Swal.fire({
      icon: 'error',
      title: 'Oops...',
      text: 'Has ingresado incorrectamente el correo o contraseña.',
    });
  }

  private construirFormularioLogin() {
    this.loginForm = new FormGroup({
      correo: new FormControl('', [Validators.required]),
      contrasena: new FormControl('', [Validators.required]),
    });
  }



}
