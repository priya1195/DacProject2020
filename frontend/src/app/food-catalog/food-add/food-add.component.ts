import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Food } from 'src/app/classes/Food';
import { Restaurent } from 'src/app/classes/Restaurent';
import { FoodService } from '../food.service';
import { RestaurentService } from '../restaurent.service';

@Component({
  selector: 'app-food-add',
  templateUrl: './food-add.component.html',
  styleUrls: ['./food-add.component.css']
})
export class FoodAddComponent implements OnInit {

  food:Food=new Food();
  restauent=new Restaurent();

  constructor(private foodService: FoodService, private router: Router,
    private restaurentService:RestaurentService) { }

  ngOnInit(): void {
  }

  saveFood() {
    this.getRestaurent(this.restauent.rid);
   // console.log(this.restauent);
    this.food.selectedRestaurent=this.restauent;
   // console.log(this.food);
    this.foodService.addFoodDetails(this.food).subscribe(
      data => console.log(data), error => console.log(error));
    this.food = new Food();
    this.gotoFoodList();
  }

  onSubmit() {
    this.saveFood();    
  }

  gotoFoodList() {
    this.router.navigate(['/admin-food-list']);
  }

   getRestaurent(id:number){
  
    this.restaurentService.getRestaurentById(id).subscribe(
      data=>{ console.log(data);
      this.restauent=data;
    },
      error=>{console.log("Exception");}
    )
}

/*  getRestaurent(name:String){
  
  this.restaurentService.getRestaurentByName(name).subscribe(
    data=>{ console.log(data);
    this.restauent=data;
  },
    error=>{console.log("Exception");}
  )
}  */
}
