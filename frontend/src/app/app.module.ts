import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderFooterModule } from './header-footer/header-footer.module';
import { HomeComponent } from './home/home.component';
import { AccountModule } from './account/account.module';
import { HttpClientModule } from '@angular/common/http';
import { CustomerViewComponent } from './customer-view/customer-view.component';
import { FoodCatalogModule } from './food-catalog/food-catalog.module';
import { AdminViewComponent } from './admin-view/admin-view.component';
import { CustomerModule } from './customer/customer.module';
import { CartModule } from './cart/cart.module';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CustomerViewComponent,
    AdminViewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HeaderFooterModule,
    AccountModule,
    HttpClientModule,
    FoodCatalogModule,
    CustomerModule,
    CartModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
