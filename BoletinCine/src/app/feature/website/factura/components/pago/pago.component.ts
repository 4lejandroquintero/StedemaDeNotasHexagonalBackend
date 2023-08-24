import { PagosService } from '@shared/services/pago/pagos.service';
import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-pago',
  templateUrl: './pago.component.html',
  styleUrls: ['./pago.component.scss']
})
export class PagoComponent implements OnInit {
  @Input() idFactura: number;
  @Input() valorTotalFactura: number;
  formPago: FormGroup;
  pago: any = {};
  idPago: string;
  valorAPagar: number;

  constructor(
    private pagosService: PagosService,
    private route: Router,
  ) { }

  ngOnInit(): void {
    this.construirFormularioPago();
    this.pago.idFactura = this.idFactura;
  }

  generarPago(){
    this.valorAPagar = this.formPago.get('valorAPagar').value;
    if(this.valorAPagar < this.valorTotalFactura){
      return this.alertaError();
    }
    this.alertaConfirmacion().then((result) => {
      if (result.isConfirmed) {
        if(this.formPago.valid){
          this.pago.valorAPagar = this.formPago.get('valorAPagar').value;
          this.pagosService.crear(this.pago).subscribe(numeroPago => {
            this.idPago = numeroPago.valor.toString();
            this.route.navigate(['/comprobante/pago', this.idPago]);
          });
        }
        Swal.fire(
          'Pago realizado!',
          'Se ha realizado el pago exitosamente',
          'success'
        );
      }
    });
  }



  alertaError(){
    Swal.fire({
      icon: 'error',
      title: 'Oops...',
      text: 'Has ingresado un valor menor al valor a pagar',
    });
  }

  alertaConfirmacion(){
    return Swal.fire({
      title: '¿Estás seguro?',
      text: 'Asegurate de ingresar correctamente los valores',
      icon: 'warning',
      showCancelButton: true,
      cancelButtonColor: '#d33',
      confirmButtonColor: '#3085d6',
      confirmButtonText: 'Yes!'
    });
  }

  private construirFormularioPago(){
    this.formPago = new FormGroup({
      valorAPagar: new FormControl('', [Validators.required])
    });
  }
}
