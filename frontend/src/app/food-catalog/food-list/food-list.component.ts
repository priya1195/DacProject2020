import { Component, OnInit } from '@angular/core';
import { FoodService } from '../food.service';
import { Observable } from 'rxjs';
import { Food } from '../../classes/Food';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/customer/customer.service';
import { CartItemsService } from 'src/app/cart/cart-items.service';
import { CartItems } from 'src/app/classes/CartItems';
import { Cart } from 'src/app/classes/Cart';

@Component({
  selector: 'app-food-list',
  templateUrl: './food-list.component.html',
  styleUrls: ['./food-list.component.css']
})
export class FoodListComponent implements OnInit {

  foods: Observable<Food[]>;
  email:String;
  cartitem=new CartItems();
  cart=new Cart();

  constructor(private foodService: FoodService, 
    private customerService: CustomerService,
    private cartiteamService:CartItemsService,
    private router: Router) { }

  ngOnInit(): void {
    this.fetchFoodList();
  }

  fetchFoodList() {
    this.foods = this.foodService.getFoodList();
  }

  foodDetails(id: number) {
   // this.router.navigate(['details', id]);
   this.getFood(id);
   this.email=sessionStorage['Email']; 
   this.getCustomerByEmail(this.email);
   /* this.cartitem.quantity=1;
   this.cartitem.cart=this.cart;
   console.log("Ready :"+this.cartitem);
  this.addtoCartItems(this.cartitem); */
  }
  
  getFood(id: number){
    this.foodService.getOneFood(id).subscribe(
      data=>{ console.log(data);
        this.cartitem.food=data;
        this.cartitem.price=data.price;
        //console.log( this.cartitem.food);
      },
      error=>{ console.log("Exception");}
    )}

  getCustomerByEmail(email){
    this.customerService.getCustomerByEmail(email).subscribe(
      data=>{console.log(data);
      console.log(data.cart.cartId);
      this.cart=data.cart;
      this.cartitem.quantity=1;
     this.cartitem.cart=this.cart;
     sessionStorage['CartId'] = this.cart.cartId;
     //console.log("final data:"+this.cartitem);
      this.addtoCartItems(this.cartitem);
      //this.router.navigate(["/cart"]);
    },
      error=>{console.log("Exception");}
    )}

 addtoCartItems(cartitem){
   this.cartiteamService.addcartItems(cartitem).subscribe(
    data=>{console.log(data);},
    error=>{console.log("Exception");}
   )}
}
