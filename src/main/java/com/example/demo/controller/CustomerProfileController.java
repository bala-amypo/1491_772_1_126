package com.example.demo.controller;

import com.example.demo.model.CustomerProfile;
import com.example.demo.service.CustomerProfileService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerProfileController {

    private final CustomerProfileService customerService;

    public CustomerProfileController(CustomerProfileService customerService) {
        this.customerService = customerService;
    }

    // Create a new customer
    @PostMapping
    public CustomerProfile createCustomer(@RequestBody CustomerProfile customer) {
        return customerService.createCustomer(customer);
    }

    // Get customer by ID
    @GetMapping("/{id}")
    public CustomerProfile getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    // Get customer by customerId (unique identifier)
    @GetMapping("/byCustomerId/{customerId}")
    public CustomerProfile getCustomerByCustomerId(@PathVariable String customerId) {
        return customerService.getCustomerByCustomerId(customerId);
    }

    // Get all customers
    @GetMapping
    public List<CustomerProfile> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // Update customer tier
    @PutMapping("/{id}/tier")
    public void updateTier(@PathVariable Long id, @RequestParam String tier) {
        customerService.updateTier(id, tier);
    }

    // Update customer status (active/inactive)
    @PutMapping("/{id}/status")
    public void updateStatus(@PathVariable Long id, @RequestParam boolean active) {
        customerService.updateStatus(id, active);
    }
}
