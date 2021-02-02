import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../classes/Customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private baseUrl = 'http://localhost:8080'

  constructor(private http: HttpClient) { }

  getOneCustomer(id: number): Observable<any> {
    return this.http.get(this.baseUrl+'/customers/'+id);
  }

  getCustomerList(): Observable<any> {
    return this.http.get(this.baseUrl+'/customers');
  }

  getCustomerByEmail(emailId: String): Observable<any> {
    return this.http.get(this.baseUrl+'/customers/email/'+emailId);
  }

  deleteCustomerDetails(id: number): Observable<any> {
    return this.http.delete(this.baseUrl+'/customers/'+id);
  }

  addCustomerDetails(customer:Customer): Observable<any> {
    return this.http.post(this.baseUrl+'/customers/', customer);
  }

  updateCustomerDetails(customer:Customer,id:number): Observable<Object> {
    return this.http.put(this.baseUrl+'/customers/'+id, customer);
  }

  deleteUserDetails(id: number): Observable<any> {
    return this.http.delete(this.baseUrl+'/login/'+id);
  }
}
