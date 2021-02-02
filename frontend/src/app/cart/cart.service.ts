import { Injectable } from '@angular/core';
import{HttpClient, HttpHeaders} from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { Cart } from '../classes/Cart';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  private baseUrl = 'http://localhost:8080'

  constructor(private http:HttpClient) { }

  public addcart(cart:Cart):Observable<any>{
    return this.http.post<any>(this.baseUrl+'/cart',cart);
  }
}
