package com.example.customer_service.service;

import com.example.customer_service.model.Customer;
import com.example.customer_service.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public List<Customer> getAllCustomer(List<Long> customerIds) {
        return customerRepository.findAllById(customerIds);
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void delete(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    public Customer updateCustomer(Customer customer) {
       return customerRepository.save(customer);
    }
}
