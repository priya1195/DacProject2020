import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './account/login/login.component';
import { RegistrationComponent } from './account/registration/registration.component';
import { AdminViewComponent } from './admin-view/admin-view.component';
import { CartItemsComponent } from './cart/cart-items/cart-items.component';
import { CartComponent } from './cart/cart/cart.component';
import { CustomerViewComponent } from './customer-view/customer-view.component';
import { CustomerListComponent } from './customer/customer-list/customer-list.component';
import { CustomerUpdateComponent } from './customer/customer-update/customer-update.component';
import { AdminFoodListComponent } from './food-catalog/admin-food-list/admin-food-list.component';
import { FoodAddComponent } from './food-catalog/food-add/food-add.component';
import { FoodListComponent } from './food-catalog/food-list/food-list.component';
import { FoodUpdateComponent } from './food-catalog/food-update/food-update.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  {path:'', redirectTo:'home', pathMatch:'full'},

  {path:'home', component: HomeComponent},
  {path:'login', component: LoginComponent},
  {path:'registration',component:RegistrationComponent},

  {path:'customer-view', component: CustomerViewComponent},
  {path:'food' ,component:FoodListComponent},
  
  {path:'admin-view', component: AdminViewComponent},
  {path:'admin-food-list', component: AdminFoodListComponent},
  {path:'app-food-add',component:FoodAddComponent},
  {path:'app-food-update/:id',component:FoodUpdateComponent},

  {path:'customer-list', component: CustomerListComponent},
  {path:'customer-update/:id',component:CustomerUpdateComponent},
  {path:'cart',component:CartItemsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
