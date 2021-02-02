import { Injectable } from '@angular/core';
import{HttpClient, HttpHeaders} from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { User } from '../classes/User'
import { Customer } from '../classes/Customer';
import { Restaurent } from '../classes/Restaurent';
import { Admin } from '../classes/Admin';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private httpheader={headers: new HttpHeaders({'Content-type':'application/json'})}

  constructor(private http:HttpClient) { }

  public loginUser(user :User):Observable<any>{
    return this.http.post<any>("http://localhost:8080/login",user);
  }

  public registerUser(user :User){
    return this.http.post<any>("http://localhost:8080/register",user);
  }

  public addCustomer(customer:Customer):Observable<any>{
    return this.http.post<any>("http://localhost:8080/customers",customer);
  }

  public addRestaurent(restaurent:Restaurent):Observable<any>{
    return this.http.post<any>("http://localhost:8080/restaurents",restaurent);
  }

  public addAdmin(admin:Admin):Observable<any>{
    return this.http.post<any>("http://localhost:8080/admin",admin);
  }
}
