import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { CustomerService } from '../services/customer.service';
import { Customer } from '../models/customer';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css'],
  standalone: true,
  imports: [CommonModule, FormsModule]
})
export class CustomerComponent implements OnInit {
  customers: Customer[] = [];
  customer: Customer = { name: '', email: '', phone: '', password: '' };
  isEditMode: boolean = false;

  constructor(private customerService: CustomerService) {}

  ngOnInit(): void {
    this.getCustomers();
  }

  getCustomers() {
    this.customerService.getAll().subscribe(data => this.customers = data);
  }

  saveCustomer() {
    if (this.isEditMode) {
      this.customerService.update(this.customer.customerId!, this.customer)
        .subscribe(() => { this.getCustomers(); this.resetForm(); });
    } else {
      this.customerService.save(this.customer)
        .subscribe(() => { this.getCustomers(); this.resetForm(); });
    }
  }

  editCustomer(cust: Customer) {
    this.customer = { ...cust };
    this.isEditMode = true;
  }

  deleteCustomer(id: number) {
    this.customerService.delete(id).subscribe(() => this.getCustomers());
  }

  resetForm() {
    this.customer = { name: '', email: '', phone: '', password: '' };
    this.isEditMode = false;
  }
}
