import { Component } from '@angular/core';
import { CustomerComponent } from './customer/customer.component';

@Component({
  selector: 'app-root',
  template: '<app-customer></app-customer>',
  standalone: true,
  imports: [CustomerComponent]
})
export class AppComponent {}
