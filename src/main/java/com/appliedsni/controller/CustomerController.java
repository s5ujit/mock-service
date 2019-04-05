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
    public Page<CustomerEntity> getQuestions(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }


    @PostMapping("/customer")
    public CustomerEntity createQuestion(@Valid @RequestBody CustomerEntity question) {
        return customerRepository.save(question);
    }

    @PutMapping("/customer/{id}")
    public CustomerEntity updateQuestion(@PathVariable Long questionId,
                                   @Valid @RequestBody CustomerEntity questionRequest) {
        return customerRepository.findById(questionId)
                .map(question -> {
                    question.setTitle(questionRequest.getTitle());
                    question.setDescription(questionRequest.getDescription());
                    return customerRepository.save(question);
                }).orElseThrow(() -> new ResourceNotFoundException("customer not found with id " + questionId));
    }


    @DeleteMapping("/customer/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable Long questionId) {
        return customerRepository.findById(questionId)
                .map(question -> {
                	customerRepository.delete(question);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("customer not found with id " + questionId));
    }
}
