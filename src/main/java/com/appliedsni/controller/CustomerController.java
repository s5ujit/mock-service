package com.appliedsni.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.appliedsni.exception.ResourceNotFoundException;
import com.appliedsni.model.CustomerEntity;
import com.appliedsni.repository.CustomerRepository;

import javax.validation.Valid;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customer")
    public Page<CustomerEntity> getCustomers(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }


    @PostMapping("/customer")
    public CustomerEntity createCustomer(@Valid @RequestBody CustomerEntity customer) {
        return customerRepository.save(customer);
    }

    @PutMapping("/customer/{id}")
    public CustomerEntity updateCustomer(@PathVariable Long customerId,
                                   @Valid @RequestBody CustomerEntity customerRequest) {
        return customerRepository.findById(customerId)
                .map(customer -> {
                    customer.setTitle(customerRequest.getTitle());
                    customer.setDescription(customerRequest.getDescription());
                    return customerRepository.save(customer);
                }).orElseThrow(() -> new ResourceNotFoundException("customer not found with id " + customerId));
    }


    @DeleteMapping("/customer/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long customerId) {
        return customerRepository.findById(customerId)
                .map(customer -> {
                	customerRepository.delete(customer);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("customer not found with id " + customerId));
    }
}
