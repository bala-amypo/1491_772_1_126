package com.example.demo.service;

import com.example.demo.model.CustomerProfile;

import java.util.List;
import java.util.Optional;

public interface CustomerProfileService {
    CustomerProfile createCustomer(CustomerProfile customer);
    Optional<CustomerProfile> getCustomerById(Long id);
    Optional<CustomerProfile> getCustomerByCustomerId(String customerId);
    List<CustomerProfile> getAllCustomers();
    CustomerProfile updateTier(Long id, String newTier);
    CustomerProfile updateStatus(Long id, boolean active);
}
