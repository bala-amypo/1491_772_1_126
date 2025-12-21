package com.example.demo.service.impl;

import java.util.*;
import org.springframework.stereotype.Service;
import com.example.demo.model.CustomerProfile;
import com.example.demo.repository.CustomerProfileRepository;
import com.example.demo.service.CustomerProfileService;

@Service
public class CustomerProfileServiceImpl implements CustomerProfileService {

    private final CustomerProfileRepository repo;

    public CustomerProfileServiceImpl(CustomerProfileRepository repo) {
        this.repo = repo;
    }

    public CustomerProfile createCustomer(CustomerProfile c) {
        if (repo.findByCustomerId(c.getCustomerId()).isPresent())
            throw new IllegalArgumentException("Customer ID already exists");
        return repo.save(c);
    }

    public CustomerProfile getCustomerById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));
    }

    public CustomerProfile findByCustomerId(String customerId) {
        return repo.findByCustomerId(customerId)
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));
    }

    public List<CustomerProfile> getAllCustomers() {
        return repo.findAll();
    }

    public CustomerProfile updateTier(Long id, String tier) {
        CustomerProfile c = getCustomerById(id);
        c.setCurrentTier(tier);
        return repo.save(c);
    }

    public CustomerProfile updateStatus(Long id, boolean active) {
        CustomerProfile c = getCustomerById(id);
        c.setActive(active);
        return repo.save(c);
    }
}
