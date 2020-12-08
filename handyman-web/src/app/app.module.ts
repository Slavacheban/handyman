import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {MainLayoutComponent} from './shared/components/main-layout/main-layout.component';
import {OrderListPageComponent} from './order-list-page/order-list-page.component';
import {ViewHandymanModalComponent} from './view-handyman-modal/view-handyman-modal.component';
import {ViewOrderModalComponent} from './view-order-modal/view-order-modal.component';
import {HandymanListPageComponent} from './handyman-list-page/handyman-list-page.component';
import {LoginPageComponent} from './login-page/login-page.component';
import {ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {NgxDatatableModule} from "@swimlane/ngx-datatable";
import {ModalModule} from "ngx-bootstrap/modal";
import {BsDropdownModule} from "ngx-bootstrap/dropdown";
import {DatePipe} from "@angular/common";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

@NgModule({
  declarations: [
    AppComponent,
    MainLayoutComponent,
    OrderListPageComponent,
    ViewHandymanModalComponent,
    ViewOrderModalComponent,
    HandymanListPageComponent,
    LoginPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgxDatatableModule,
    ModalModule.forRoot(),
    BsDropdownModule.forRoot(),
    BrowserAnimationsModule
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule {
}
