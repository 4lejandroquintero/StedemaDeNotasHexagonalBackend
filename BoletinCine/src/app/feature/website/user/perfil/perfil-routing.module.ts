import { NgModule } from '@angular/core';
import { RouterModule, Routes} from '@angular/router';
import { PerfilComponent } from './components/perfil.component';
import { SecurityGuard } from '@core/guard/security.guard';

const routes: Routes = [
  {
    path:'',
    component: PerfilComponent,
    canActivate: [SecurityGuard]
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PerfilRoutingModule { }
