import { Injectable } from '@angular/core';
import{HttpClient, HttpHeaders} from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { CartItems } from '../classes/CartItems';

@Injectable({
  providedIn: 'root'
})
export class CartItemsService {
  private baseUrl = 'http://localhost:8080'

  constructor(private http:HttpClient) { }

  public addcartItems(cartitem:CartItems):Observable<any>{
    return this.http.post(this.baseUrl+'/cartitems',cartitem);
  }

  getCartItemsList(): Observable<any> {
    return this.http.get(this.baseUrl+'/cartitems');
  }

  deleteCartItemDetails(id: number): Observable<any> {
    return this.http.delete(this.baseUrl+'/cartitems/'+id);
  }

  updateCartItemDetails(cartitem:CartItems,id:number): Observable<Object> {
    return this.http.put(this.baseUrl+'/cartitems/'+id, cartitem);
  } 

  /* getOneFood(id: number): Observable<any> {
    return this.http.get(this.baseUrl+'/foods/'+id);
  }

  getFoodList(): Observable<any> {
    return this.http.get(this.baseUrl+'/foods');
  }

  deleteFoodDetails(id: number): Observable<any> {
    return this.http.delete(this.baseUrl+'/foods/'+id);
  }


  */
}
