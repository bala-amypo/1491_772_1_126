package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.CustomerProfile;
import com.example.demo.service.CustomerProfileService;

@RestController
@RequestMapping("/customer")
public class CustomerProfileController {

    @Autowired
    private CustomerProfileService service;

    // Create a new customer profile
    @PostMapping("/create")
    public CustomerProfile createCustomer(@RequestBody CustomerProfile customer) {
        return service.insertCustomer(customer);
    }

    // Get all customer profiles
    @GetMapping("/all")
    public List<CustomerProfile> getAllCustomers() {
        return service.getAllCustomers();
    }

    // Get a customer profile by ID
    @GetMapping("/{id}")
    public Optional<CustomerProfile> getCustomerById(@PathVariable Long id) {
        return service.getCustomerById(id);
    }

    // Delete a customer profile by ID
    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        Optional<CustomerProfile> customer = service.getCustomerById(id);
        if (customer.isPresent()) {
            service.deleteCustomer(id);
            return "Successfully deleted";
        } else {
            return "Id not found";
        }
    }
}
