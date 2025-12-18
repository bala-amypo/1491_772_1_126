package com.example.demo.service;

import com.example.demo.entity.CustomerProfile;
import com.example.demo.repository.CustomerProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CustomerProfileService {

    @Autowired
    private CustomerProfileRepository repository;

    public void createCustomer(CustomerProfile customer) {
        repository.save(customer);
    }

    public CustomerProfile getCustomerById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Customer not found"));
    }

    public void updateTier(Long id, String newTier) {
        CustomerProfile customer = getCustomerById(id);
        customer.setCurrentTier(newTier);
        repository.save(customer);
    }

    public void updateStatus(Long id, boolean active) {
        CustomerProfile customer = getCustomerById(id);
        customer.setActive(active);
        repository.save(customer);
    }
}
