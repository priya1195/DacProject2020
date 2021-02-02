import { Component, OnInit } from '@angular/core';
import { FoodService } from '../food.service';
import { Observable } from 'rxjs';
import { Food } from '../../classes/Food';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-food-list',
  templateUrl: './admin-food-list.component.html',
  styleUrls: ['./admin-food-list.component.css']
})
export class AdminFoodListComponent implements OnInit {

  foods: Observable<Food[]>;

  constructor(private foodService: FoodService, private router: Router) { }

  ngOnInit(): void {
    this.fetchFoodList();
  }
  fetchFoodList() {
    this.foods = this.foodService.getFoodList();
  }

  deleteFood(id: number) {
    this.foodService.deleteFoodDetails(id)
      .subscribe(
        data => {
          console.log(data);
          this.fetchFoodList();
        },
        error => console.log(error));
  }

  addFood(){
    this.router.navigate(['app-food-add']);
  }

  updateFood(food:Food){
    this.router.navigate(['app-food-update', food]);
  }
}
