package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.CustomerProfile;

public interface CustomerProfileService {

    // Insert a new customer profile
    CustomerProfile insertCustomerProfile(CustomerProfile cp);

    // Get all customer profiles
    List<CustomerProfile> getAll();

    // Get a customer profile by ID
    Optional<CustomerProfile> getById(Long id);

    // Update an existing customer profile
    CustomerProfile updateCustomerProfile(CustomerProfile cp);

    // Delete a customer profile by ID
    void deleteCustomerProfile(Long id);

    // Optional: Find by unique fields like email or customerId
    Optional<CustomerProfile> findByEmail(String email);
    Optional<CustomerProfile> findByCustomerId(String customerId);
}
