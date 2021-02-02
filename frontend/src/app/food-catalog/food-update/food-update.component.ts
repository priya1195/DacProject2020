import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Food } from 'src/app/classes/Food';
import { Restaurent } from 'src/app/classes/Restaurent';
import { FoodService } from '../food.service';
import { RestaurentService } from '../restaurent.service';

@Component({
  selector: 'app-food-update',
  templateUrl: './food-update.component.html',
  styleUrls: ['./food-update.component.css']
})
export class FoodUpdateComponent implements OnInit {

  id: number;
  food = new Food();
  restauent = new Restaurent();
  
  constructor(private route: ActivatedRoute,
    private router: Router,
    private foodService: FoodService,
    private restaurentService:RestaurentService) { }

  ngOnInit(): void {
    this.food = new Food();

    this.id = this.route.snapshot.params['id'];
    
    this.foodService.getOneFood(this.id)
      .subscribe(data => {
        console.log(data)
        this.food = data;
      }, error => console.log(error));
  }

  updateFood() {
    //this.getRestaurent(this.restauent.rid);
   // this.food.selectedRestaurent=this.restauent;

    this.foodService.updateFoodDetails(this.food,this.id)
      .subscribe(data => console.log(data), error => console.log(error));
    this.food = new Food();
    this.gotoFoodList();
  }

  onSubmit() {
    this.updateFood();    
  }

  gotoFoodList() {
    this.router.navigate(['/admin-food-list']);
  }

 /*  getRestaurent(id:number){
  
    this.restaurentService.getRestaurentById(id).subscribe(
      data=>{ console.log(data);
      this.restauent=data;
    },
      error=>{console.log("Exception");}
    )
} */
}
