package com.example.demo.repository;

import com.example.demo.model.CustomerProfile;

import java.util.List;
import java.util.Optional;

public interface CustomerProfileRepository {

    CustomerProfile save(CustomerProfile customer);

    Optional<CustomerProfile> findById(Long id);

    List<CustomerProfile> findAll();

    Optional<CustomerProfile> findByCustomerId(String customerId);

    Optional<CustomerProfile> findByEmail(String email);

    Optional<CustomerProfile> findByPhone(String phone);
}
