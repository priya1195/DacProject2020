import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RestaurentService {

  private baseUrl = 'http://localhost:8080'

  constructor(private http: HttpClient) { }

  getRestaurentById(id: number): Observable<any> {
    return this.http.get(this.baseUrl+'/restaurents/'+id);
  }

  getRestaurentByName(name:String): Observable<any> {
    return this.http.get(this.baseUrl+'/restaurents/name/'+name);
  }
}
