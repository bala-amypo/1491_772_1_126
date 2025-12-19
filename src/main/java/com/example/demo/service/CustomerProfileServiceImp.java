package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CustomerProfile;
import com.example.demo.repository.CustomerProfileRepo;

@Service
public class CustomerProfileServiceImp implements CustomerProfileService {

    @Autowired
    private CustomerProfileRepo repo;

    @Override
    public CustomerProfile insertCustomerProfile(CustomerProfile cp) {
        return repo.save(cp);
    }

    @Override
    public List<CustomerProfile> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<CustomerProfile> getById(Long id) {
        return repo.findById(id);
    }

    @Override
    public CustomerProfile updateCustomerProfile(CustomerProfile cp) {
        return repo.save(cp);
    }

    @Override
    public void deleteCustomerProfile(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Optional<CustomerProfile> findByEmail(String email) {
        return repo.findByEmail(email);
    }

    @Override
    public Optional<CustomerProfile> findByCustomerId(String customerId) {
        return repo.findByCustomerId(customerId);
    }
}
