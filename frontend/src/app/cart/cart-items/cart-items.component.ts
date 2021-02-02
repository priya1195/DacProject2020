import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Cart } from 'src/app/classes/Cart';
import { CartItems } from 'src/app/classes/CartItems';
import { CartItemsService } from '../cart-items.service';

@Component({
  selector: 'app-cart-items',
  templateUrl: './cart-items.component.html',
  styleUrls: ['./cart-items.component.css']
})
export class CartItemsComponent implements OnInit {

  cart=new Cart();
 // cartItems:Observable<CartItems[]>
  cartItems:CartItems[];
  newQuantity:number;
  totalAmount=0.0;
  index:number;

  constructor( private router: Router,
    private cartiteamService:CartItemsService) { }

  ngOnInit(): void {
    this.cart.cartId=sessionStorage["CartId"];
    console.log("CartId:"+this.cart.cartId);
    this.fetchCartItemsList();
  }

  fetchCartItemsList() {
    this.cartiteamService.getCartItemsList().subscribe(
      data=>{console.log("Received data:"+data);
      this.cartItems=data
      this.totalAmount=0.0;
       for(let i=0;i<this.cartItems.length;i++)
       {
         // alert(this.cartItems[i].price);
          this.totalAmount+=this.cartItems[i].price;
         // console.log(this.totalAmount);
       }
    },
      error=>{console.log("Exception");}
    )
  }
  
  removeFromCart(id: number) {
    this.cartiteamService.deleteCartItemDetails(id)
      .subscribe(
        data => {
          console.log(data);
          this.fetchCartItemsList();
        },
        error => console.log(error));
  }

  updateValue(value,cartItem){
    this.newQuantity=cartItem.quantity+value;   
    cartItem.quantity=this.newQuantity
    cartItem.price=cartItem.quantity*cartItem.food.price;
    console.log(this.newQuantity);

    if(this.newQuantity==0){
      this.removeFromCart(cartItem.id);
    }else{
      this.cartiteamService.updateCartItemDetails(cartItem,cartItem.id)
      .subscribe(
        data => {
          console.log(data);
          this.totalAmount=0.0;
          for(let i=0;i<this.cartItems.length;i++)
       {
        //  alert(this.cartItems[i].price);
          this.totalAmount+=this.cartItems[i].price;
         // console.log(this.totalAmount);
       }
          console.log("updated");
        },
        error => console.log(error));
    }

  }
}
