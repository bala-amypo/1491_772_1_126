package com.example.demo.service.impl;

import com.example.demo.model.CustomerProfile;
import com.example.demo.repository.CustomerProfileRepository;
import com.example.demo.service.CustomerProfileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerProfileServiceImpl implements CustomerProfileService {

    private final CustomerProfileRepository repository;

    public CustomerProfileServiceImpl(CustomerProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public CustomerProfile createCustomer(CustomerProfile customer) {
        return repository.save(customer);
    }

    @Override
    public Optional<CustomerProfile> getCustomerById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<CustomerProfile> getCustomerByCustomerId(String customerId) {
        return repository.findByCustomerId(customerId);
    }

    @Override
    public List<CustomerProfile> getAllCustomers() {
        return repository.findAll();
    }

    @Override
    public CustomerProfile updateTier(Long id, String newTier) {
        CustomerProfile customer = repository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
        customer.setCurrentTier(newTier);
        return repository.save(customer);
    }

    @Override
    public CustomerProfile updateStatus(Long id, boolean active) {
        CustomerProfile customer = repository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
        customer.setActive(active);
        return repository.save(customer);
    }
}
