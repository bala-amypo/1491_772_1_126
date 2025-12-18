package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CustomerProfile;
import com.example.demo.repository.CustomerProfileRepository;

@Service
public class CustomerProfileService {

    @Autowired
    CustomerProfileRepository repository;

    public CustomerProfile createCustomer(CustomerProfile cp) {
        return repository.save(cp);
    }

    public List<CustomerProfile> getAllCustomers() {
        return repository.findAll();
    }
}
