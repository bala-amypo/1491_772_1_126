package com.example.demo.service.impl;

import com.example.demo.entity.CustomerProfile;
import com.example.demo.repository.CustomerProfileRepository;
import com.example.demo.service.CustomerProfileService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerProfileServiceImpl implements CustomerProfileService {

    private final List<CustomerProfile> storage = new ArrayList<>();
    private Long idCounter = 1L;

    @Override
    public CustomerProfile createCustomer(CustomerProfile customer) {
        customer.setId(idCounter++);
        storage.add(customer);
        return customer;
    }

    @Override
    public CustomerProfile getCustomerById(Long id) {
        return storage.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public CustomerProfile findByCustomerId(String customerId) {
        return storage.stream().filter(c -> c.getCustomerId().equals(customerId)).findFirst().orElse(null);
    }

    @Override
    public List<CustomerProfile> getAllCustomers() {
        return storage;
    }

    @Override
    public CustomerProfile updateTier(Long id, String newTier) {
        CustomerProfile customer = getCustomerById(id);
        if (customer != null) customer.setCurrentTier(newTier);
        return customer;
    }

    @Override
    public CustomerProfile updateStatus(Long id, boolean active) {
        CustomerProfile customer = getCustomerById(id);
        if (customer != null) customer.setActive(active);
        return customer;
    }
}
