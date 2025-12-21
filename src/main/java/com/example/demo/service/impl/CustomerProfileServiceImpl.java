package com.example.demo.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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

    @Override
    public CustomerProfile createCustomer(CustomerProfile customer) {
        if (repo.findByCustomerId(customer.getCustomerId()).isPresent()) {
            throw new IllegalArgumentException("Customer ID already exists");
        }
        return repo.save(customer);
    }

    @Override
    public CustomerProfile getCustomerById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));
    }

    @Override
    public Optional<CustomerProfile> findByCustomerId(String customerId) {
        return repo.findByCustomerId(customerId);
    }

    @Override
    public List<CustomerProfile> getAllCustomers() {
        return repo.findAll();
    }

    @Override
    public CustomerProfile updateTier(Long id, String newTier) {
        CustomerProfile c = getCustomerById(id);
        c.setCurrentTier(newTier);
        return repo.save(c);
    }

    @Override
    public CustomerProfile updateStatus(Long id, boolean active) {
        CustomerProfile c = getCustomerById(id);
        c.setActive(active);
        return repo.save(c);
    }
}
