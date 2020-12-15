import {NgModule} from '@angular/core';
import {PreloadAllModules, RouterModule, Routes} from '@angular/router';
import {MainLayoutComponent} from './shared/components/main-layout/main-layout.component';
import {OrderListPageComponent} from './order-list-page/order-list-page.component';
import {HandymanListPageComponent} from './handyman-list-page/handyman-list-page.component';
import {LoginPageComponent} from "./login-page/login-page.component";
import {AuthGuard} from "./shared/services/auth-guard";

const routes: Routes = [
  {
    path: '', component: MainLayoutComponent, children: [
      {path: '', redirectTo: 'orders', pathMatch: 'full'},
      {path: 'handyman', component: HandymanListPageComponent, canActivate: [AuthGuard]},
      {path: 'orders', component: OrderListPageComponent, canActivate: [AuthGuard]},
      {path: 'login', component: LoginPageComponent},
      {path: '**', component: OrderListPageComponent, canActivate: [AuthGuard]}
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
