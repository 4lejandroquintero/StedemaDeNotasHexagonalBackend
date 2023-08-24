import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NotfoundComponent } from '@core/components/notfound/notfound.component';
import { AdminGuard } from '@core/guard/admin.guard';



const routes: Routes = [
  {
    path: '',
    loadChildren: () => import('./feature/website/website.module').then(m => m.WebsiteModule)
  },
  {
    path: 'cms',
    canActivate:[AdminGuard],
    loadChildren: () => import('./feature/cms/cms.module').then(m => m.CmsModule)
  },
  { path: '**', component: NotfoundComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { relativeLinkResolution: 'legacy' })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
