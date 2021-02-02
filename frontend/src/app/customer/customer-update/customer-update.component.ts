import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from 'src/app/classes/Customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-customer-update',
  templateUrl: './customer-update.component.html',
  styleUrls: ['./customer-update.component.css']
})
export class CustomerUpdateComponent implements OnInit {

  id: number;
  customer = new Customer();

  constructor(private route: ActivatedRoute,
    private router: Router,
    private customerService: CustomerService) { }

  ngOnInit(): void {
    this.customer = new Customer();

    this.id = this.route.snapshot.params['id'];
    
    this.customerService.getOneCustomer(this.id)
      .subscribe(data => {
        console.log(data)
        this.customer = data;
      }, error => console.log(error));
  }
  updateCustomer() {
    //this.getRestaurent(this.restauent.rid);
   // this.food.selectedRestaurent=this.restauent;

    this.customerService.updateCustomerDetails(this.customer,this.id)
      .subscribe(data => console.log(data), error => console.log(error));
    this.customer = new Customer();
    this.gotoCustomerList();
  }

  onSubmit() {
    this.updateCustomer();    
  }

  gotoCustomerList() {
    this.router.navigate(['/customer-list']);
  }
}
