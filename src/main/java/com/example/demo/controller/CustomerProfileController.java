package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.CustomerProfile;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerProfileController {

    @Autowired
    CustomerService cs;

    @PostMapping("/postcustomer")
    public CustomerProfile postCustomer(@RequestBody CustomerProfile customer) {
        return cs.insertCustomer(customer);
    }

    @GetMapping("/getcustomers")
    public List<CustomerProfile> getAllCustomers() {
        return cs.getAll();
    }

    @GetMapping("/getcustomer/{id}")
    public Optional<CustomerProfile> getCustomerById(@PathVariable Long id) {
        return cs.getById(id);
    }

    @DeleteMapping("/deletecustomer/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        Optional<CustomerProfile> customer = cs.getById(id);
        if (customer.isPresent()) {
            cs.deleteCustomer(id);
            return "Customer deleted successfully";
        } else {
            return "Customer ID not found";
        }
    }
}
