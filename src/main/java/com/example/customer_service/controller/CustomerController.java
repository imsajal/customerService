package com.example.customer_service.controller;


import com.example.customer_service.model.Customer;
import com.example.customer_service.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RequestMapping("/v1/customer")
@RestController
public class CustomerController{

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/getById")
    public ResponseEntity<Customer> getCustomer(@RequestParam Long customerId){
        Customer customer = customerService.getCustomer(customerId);
        return customer != null ? ResponseEntity.ok(customer): ResponseEntity.notFound().build();
    }

    @GetMapping("/getAllCustomers")
    public ResponseEntity<List<Customer>> getCustomer(@RequestParam List<Long> customerIds){
        List<Customer> customers = customerService.getAllCustomer(customerIds);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Customer> getCustomer(@RequestBody Customer customer){
        Customer createdCustomer = customerService.createCustomer(customer);
        return new ResponseEntity<>(createdCustomer, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
        try {
            Customer updateCustomer = customerService.updateCustomer(customer);
            return ResponseEntity.ok(updateCustomer);
        }
        catch(Exception e){
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/deleteById/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long customerId){
        customerService.delete(customerId);
        return ResponseEntity.noContent().build();
        // status code 204
    }

    // we can improve with exception handling and transactions
}
