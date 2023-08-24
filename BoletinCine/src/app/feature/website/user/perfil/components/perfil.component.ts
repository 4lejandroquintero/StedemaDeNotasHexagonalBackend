
import { AuthService } from '@core/services/auth.service';
import { Component, OnInit } from '@angular/core';
import { Cliente } from '@models/cliente/cliente';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.scss']
})
export class PerfilComponent implements OnInit {

  cliente: Cliente | null;
  constructor(
    private authService: AuthService
  ) { }

  ngOnInit(): void {
    this.authService.cliente$.subscribe(
      (data) => {this.cliente = data;}
    );
  }

}
