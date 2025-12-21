package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.CustomerProfile;
import com.example.demo.service.CustomerProfileService;

@RestController
@RequestMapping("/customers")
public class CustomerProfileController {

    private final CustomerProfileService customerService;

    public CustomerProfileController(CustomerProfileService customerService) {
        this.customerService = customerService;
    }

    // Create customer
    @PostMapping
    public CustomerProfile createCustomer(@RequestBody CustomerProfile customer) {
        return customerService.createCustomer(customer);
    }

    // Get customer by DB id
    @GetMapping("/{id}")
    public CustomerProfile getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    // Get customer by customerId
    @GetMapping("/lookup/{customerId}")
    public CustomerProfile getCustomerByCustomerId(
            @PathVariable String customerId) {
        return customerService.findByCustomerId(customerId);
    }

    // Get all customers
    @GetMapping
    public List<CustomerProfile> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // Update tier
    @PutMapping("/{id}/tier")
    public CustomerProfile updateTier(
            @PathVariable Long id,
            @RequestParam String newTier) {
        return customerService.updateTier(id, newTier);
    }

    // Update active status
    @PutMapping("/{id}/status")
    public CustomerProfile updateStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {
        return customerService.updateStatus(id, active);
    }
}
