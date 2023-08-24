import { Component, OnInit } from '@angular/core';
import { ListaMembresia } from './model/listamembresia';
import { ClientesService } from '../cliente/shared/service/clientes.service';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
@Component({
  selector: 'app-registrarse',
  templateUrl: './registrarse.component.html',
  styleUrls: ['./registrarse.component.scss'],

})
export class RegistrarseComponent implements OnInit{
  membresias: ListaMembresia[] = [
    {value: 'ZAFIRO', viewValue: 'ZAFIRO'},
    {value: 'RUBY', viewValue: 'RUBY'},
    {value: 'ESMERALDA', viewValue: 'ESMERALDA'},
  ];

  clienteForm: FormGroup;

  constructor(
    protected clienteService: ClientesService,
    private fb: FormBuilder) {
    this.clienteForm = this.fb.group({});
  }

  ngOnInit(): void {
    this.construirFormularioCliente();
  }

  crear() {
    console.log(this.clienteForm.value);
    if(this.clienteForm.valid){
      this.clienteService.crear(this.clienteForm.value).subscribe(()=>(window.alert('Cliente creado'), this.clienteForm.reset()));

    }
  }

  private construirFormularioCliente() {
    this.clienteForm = new FormGroup({
      nombre: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required]),
      contrasena: new FormControl('', [Validators.required]),
      documentoIdentidad: new FormControl('', [Validators.required]),
      tipoMembresia: new FormControl(this.membresias[0].value, [Validators.required]),
      fechaNacimiento: new FormControl('', [Validators.required]),
    });
  }



}
