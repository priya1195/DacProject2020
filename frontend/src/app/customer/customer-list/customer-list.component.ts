import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Customer } from 'src/app/classes/Customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  customers: Observable<Customer[]>;

  constructor(private customerService: CustomerService, private router: Router) { }

  ngOnInit(): void {
    this.fetchCustomerList();
  }

  fetchCustomerList() {
    this.customers = this.customerService.getCustomerList();
  }

  deleteCustomer(id: number) {
    
    this.customerService.deleteCustomerDetails(id)
      .subscribe(
        data => {
          console.log(data);
          this.fetchCustomerList();
        },
        error => console.log(error));

  }

  updateCustomer(customer:Customer){
    this.router.navigate(['customer-update', customer]);
  }
}
