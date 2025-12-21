package com.example.demo.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.example.demo.model.CustomerProfile;
import com.example.demo.repository.CustomerProfileRepository;
import com.example.demo.service.CustomerProfileService;

@Service
public class CustomerProfileServiceImpl implements CustomerProfileService {

    private final CustomerProfileRepository customerRepo;

    public CustomerProfileServiceImpl(CustomerProfileRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public CustomerProfile createCustomer(CustomerProfile customer) {
        if (customerRepo.findByCustomerId(customer.getCustomerId()).isPresent()) {
            throw new IllegalArgumentException("Customer ID already exists");
        }
        return customerRepo.save(customer);
    }

    @Override
    public CustomerProfile getCustomerById(Long id) {
        return customerRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));
    }

    @Override
    public CustomerProfile getCustomerByCustomerId(String customerId) {
        return customerRepo.findByCustomerId(customerId)
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));
    }

    @Override
    public List<CustomerProfile> getAllCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public CustomerProfile updateTier(Long id, String newTier) {
        CustomerProfile customer = getCustomerById(id);
        customer.setCurrentTier(newTier);
        return customerRepo.save(customer);
    }

    @Override
    public CustomerProfile updateStatus(Long id, boolean active) {
        CustomerProfile customer = getCustomerById(id);
        customer.setActive(active);
        return customerRepo.save(customer);
    }
}
