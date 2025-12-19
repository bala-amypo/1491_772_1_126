package com.example.demo.repository;

import com.example.demo.entity.CustomerProfile;
import java.util.List;

public interface CustomerProfileRepository {

    CustomerProfile save(CustomerProfile customer);

    CustomerProfile findById(Long id);

    CustomerProfile findByCustomerId(String customerId);

    List<CustomerProfile> findAll();
}
