package com.example.demo.service;

import com.example.demo.model.CustomerProfile;
import java.util.List;

public interface CustomerProfileService {

    CustomerProfile createCustomer(CustomerProfile customer);

    // Correct return type according to your test expectations
    CustomerProfile getCustomerById(Long id);

    // Correct method name
    CustomerProfile getCustomerByCustomerId(String customerId);

    void updateTier(Long id, String newTier);

    void updateStatus(Long id, boolean active);

    List<CustomerProfile> getAllCustomers();
}
