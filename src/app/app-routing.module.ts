import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './account/login/login.component';
import { RegistrationComponent } from './account/registration/registration.component';
import { CustomerViewComponent } from './customer-view/customer-view.component';
import { FoodDetailComponent } from './food-catalog/food-detail/food-detail.component';
import { FoodListComponent } from './food-catalog/food-list/food-list.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  {path:'', redirectTo:'home', pathMatch:'full'},

  {path:'home', component: HomeComponent},
  {path:'login', component: LoginComponent},
  {path:'registration',component:RegistrationComponent},

  {path:'customer-view', component: CustomerViewComponent},
  {path:'food' ,component:FoodListComponent},
  { path: 'details/:id', component: FoodDetailComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
