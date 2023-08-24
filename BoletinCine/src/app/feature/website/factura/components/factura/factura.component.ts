import { ActivatedRoute } from '@angular/router';
import { FacturasService } from '@shared/services/factura/facturas.service';
import { Component, OnInit } from '@angular/core';
import { FacturaDTO } from '@shared/models/factura/factura';
import { TokenService } from '@core/services/token.service';
import { switchMap } from 'rxjs';

@Component({
  selector: 'app-factura',
  templateUrl: './factura.component.html',
  styleUrls: ['./factura.component.scss'],
})
export class FacturaComponent implements OnInit{
  idBoleto: string | null;
  dataFactura: any = {};
  factura: FacturaDTO;
  idFactura: number;

  factureishon: FacturaDTO;

  constructor(
    private facturaService: FacturasService,
    private route: ActivatedRoute,
    private tokenService: TokenService
  ) {}


  ngOnInit(): void {
    this.route.paramMap
      .pipe(
        switchMap((params) => {
          this.idBoleto = params.get('idBoleto');
          if (this.idBoleto) {
            this.dataFactura.idBoleto = parseInt(this.idBoleto);
            this.dataFactura.idCliente = parseInt(
              this.tokenService.getidCliente()
            );
            return this.facturaService.crear(this.dataFactura);
          }
          return [];
        })
      )
      .subscribe((data) =>{
        this.idFactura = data.valor;
        this.facturaService.obtenerPorID(this.idFactura).subscribe(
          ((valorFactura) => {
            this.factura = valorFactura;
          })
        );
      });
  }
}
