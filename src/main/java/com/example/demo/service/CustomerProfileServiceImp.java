package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CustomerProfile;
import com.example.demo.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo repo;

    @Override
    public CustomerProfile insertCustomer(CustomerProfile customer) {
        return repo.save(customer);
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
    public void deleteCustomer(Long id) {
        repo.deleteById(id);
    }
}
