package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repo;


    // Get All Customers
    public List<Customer> listAll() {

        return repo.findAll();
    }


    // Save / Update Customer
    public Customer save(Customer customer) {

        return repo.save(customer);
    }


    // Get Customer by ID
    public Customer get(Integer id) {

        return repo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Customer not found with ID: " + id
            ));
    }


    // Delete Customer
    public void delete(Integer id) {

        if (!repo.existsById(id)) {

            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Customer not found with ID: " + id
            );
        }

        try {

            repo.deleteById(id);

        } catch (Exception e) {

            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error deleting Customer with ID: " + id
            );
        }
    }

}