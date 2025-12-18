package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CustomerProfile;
import com.example.demo.repository.CustomerProfileRepository;
import com.example.demo.service.CustomerProfileService;

@Service
public class CustomerProfileServiceImpl implements CustomerProfileService {

    @Autowired
    private CustomerProfileRepository repository;

    @Override
    public CustomerProfile createCustomer(CustomerProfile cp) {
        return repository.save(cp);
    }

    @Override
    public List<CustomerProfile> getAllCustomers() {
        return repository.findAll();
    }
}
