package com.example.demo.service;

import com.example.demo.entity.CustomerProfile;

import java.util.List;

public interface CustomerProfileService {

    CustomerProfile createCustomer(CustomerProfile customer);

    CustomerProfile getCustomerById(Long id);

    CustomerProfile findByCustomerId(String id);

    List<CustomerProfile> getAllCustomers();

    void updateTier(Long id, String newTier);

    void updateStatus(Long id, boolean active);
}
