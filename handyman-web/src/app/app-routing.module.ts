import {NgModule} from '@angular/core';
import {PreloadAllModules, RouterModule, Routes} from '@angular/router';
import {MainLayoutComponent} from './shared/components/main-layout/main-layout.component';
import {OrderListPageComponent} from './order-list-page/order-list-page.component';
import {HandymanListPageComponent} from './handyman-list-page/handyman-list-page.component';

const routes: Routes = [
  {
    path: '', component: MainLayoutComponent, children: [
      {path: '', redirectTo: '/api/orders', pathMatch: 'full'},
      {path: 'aoi/handyman', component: HandymanListPageComponent},
      {path: 'ari/orders', component: OrderListPageComponent},
      {path: '**', component: OrderListPageComponent}
    ]
  },
  {
    path: 'admin', loadChildren: './admin/admin.module#AdminModule'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {
    preloadingStrategy: PreloadAllModules
  })],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
