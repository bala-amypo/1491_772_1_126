package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.CustomerProfile;

@Service
public interface CustomerProfileService {

    CustomerProfile insertCustomer(CustomerProfile customer);
    List<CustomerProfile> getAll();
    Optional<CustomerProfile> getById(Long id);
    void deleteCustomer(Long id);
}
