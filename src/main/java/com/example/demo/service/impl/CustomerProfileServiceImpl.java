package com.example.demo.service.impl;

import com.example.demo.model.CustomerProfile;
import com.example.demo.repository.CustomerProfileRepository;
import com.example.demo.service.CustomerProfileService;

import java.util.List;
import java.util.NoSuchElementException;

public class CustomerProfileServiceImpl implements CustomerProfileService {

    private final CustomerProfileRepository repository;

    public CustomerProfileServiceImpl(CustomerProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public CustomerProfile createCustomer(CustomerProfile customer) {
        // Check duplicate by customerId, email, phone
        repository.findByCustomerId(customer.getCustomerId())
                .ifPresent(c -> { throw new IllegalArgumentException("Customer ID already exists"); });

        repository.findByEmail(customer.getEmail())
                .ifPresent(c -> { throw new IllegalArgumentException("Email already exists"); });

        repository.findByPhone(customer.getPhone())
                .ifPresent(c -> { throw new IllegalArgumentException("Phone already exists"); });

        return repository.save(customer);
    }

    @Override
    public CustomerProfile getCustomerById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));
    }

    @Override
    public List<CustomerProfile> getAllCustomers() {
        return repository.findAll();
    }

    @Override
    public CustomerProfile getCustomerByCustomerId(String customerId) {
        return repository.findByCustomerId(customerId)
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));
    }
}
