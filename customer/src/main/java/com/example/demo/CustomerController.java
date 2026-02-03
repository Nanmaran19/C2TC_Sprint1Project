package com.example.demo;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService service;


    // Get All Customers
    @GetMapping
    public List<Customer> listAll() {

        return service.listAll();
    }


    // Get Customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<Customer> get(@PathVariable Integer id) {

        try {

            Customer customer = service.get(id);
            return new ResponseEntity<>(customer, HttpStatus.OK);

        } catch (NoSuchElementException e) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    // Add Customer
    @PostMapping
    public ResponseEntity<Customer> add(@RequestBody Customer customer) {

        service.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }


    // Update Customer
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Customer customer,
                                    @PathVariable Integer id) {

        try {

            System.out.println("Updating Customer with ID: " + id);

            Customer existingCustomer = service.get(id);

            existingCustomer.setName(customer.getName());
            existingCustomer.setEmail(customer.getEmail());
            existingCustomer.setPassword(customer.getPassword());
            existingCustomer.setPhone(customer.getPhone());

            service.save(existingCustomer);

            return new ResponseEntity<>(existingCustomer, HttpStatus.OK);

        } catch (NoSuchElementException e) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    // Delete Customer
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {

        try {

            service.delete(id);
            return ResponseEntity.ok().build();

        } catch (NoSuchElementException e) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}