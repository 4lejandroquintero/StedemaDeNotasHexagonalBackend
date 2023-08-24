import { PagosService } from '@shared/services/pago/pagos.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PagoDTO } from '@shared/models/pago/pago';

@Component({
  selector: 'app-comprobante-pago',
  templateUrl: './comprobante-pago.component.html',
  styleUrls: ['./comprobante-pago.component.scss']
})
export class ComprobantePagoComponent implements OnInit {

  idPago: string;
  pago: PagoDTO;

  constructor(
    private route: ActivatedRoute,
    private pagosService: PagosService,
  ) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(data => this.idPago = data.get('idPago'));
    console.log(this.idPago);

    this.pagosService.obtenerPorID(this.idPago).subscribe(data => {
      this.pago = data;
      console.log(data);
    }) ;

  }



}
