import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Food } from '../classes/Food';

@Injectable({
  providedIn: 'root'
})
export class FoodService {

  private baseUrl = 'http://localhost:8080'

  constructor(private http: HttpClient) { }

  getOneFood(id: number): Observable<any> {
    return this.http.get(this.baseUrl+'/foods/'+id);
  }

  getFoodList(): Observable<any> {
    return this.http.get(this.baseUrl+'/foods');
  }

  deleteFoodDetails(id: number): Observable<any> {
    return this.http.delete(this.baseUrl+'/foods/'+id);
  }

  addFoodDetails(food:Food): Observable<any> {
    return this.http.post(this.baseUrl+'/foods/', food);
  }

  updateFoodDetails(food:Food,id:number): Observable<Object> {
    return this.http.put(this.baseUrl+'/foods/'+id, food);
  }
}
