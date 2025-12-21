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
    public CustomerProfile getCustomerById(Long id) {
        Optional<CustomerProfile> customer = repository.findById(id);
        return customer.orElse(null);
    }

    @Override
    public CustomerProfile getCustomerByCustomerId(String customerId) {
        Optional<CustomerProfile> customer = repository.findByCustomerId(customerId);
        return customer.orElse(null);
    }

    @Override
    public List<CustomerProfile> getAllCustomers() {
        return repository.findAll();
    }

    @Override
    public void updateTier(Long id, String newTier) {
        Optional<CustomerProfile> optionalCustomer = repository.findById(id);
        if (optionalCustomer.isPresent()) {
            CustomerProfile customer = optionalCustomer.get();
            customer.setCurrentTier(newTier);
            repository.save(customer);
        }
    }

    @Override
    public void updateStatus(Long id, boolean active) {
        Optional<CustomerProfile> optionalCustomer = repository.findById(id);
        if (optionalCustomer.isPresent()) {
            CustomerProfile customer = optionalCustomer.get();
            customer.setActive(active);
            repository.save(customer);
        }
    }
}
