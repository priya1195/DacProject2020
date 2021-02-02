import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FoodListComponent } from './food-list/food-list.component';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AdminFoodListComponent } from './admin-food-list/admin-food-list.component';
import { FoodAddComponent } from './food-add/food-add.component';
import { FoodUpdateComponent } from './food-update/food-update.component';



@NgModule({
  declarations: [FoodListComponent,AdminFoodListComponent, FoodAddComponent, FoodUpdateComponent],
  imports: [
    CommonModule,
    HttpClientModule,
    FormsModule,
    RouterModule
  ]
})
export class FoodCatalogModule { }
