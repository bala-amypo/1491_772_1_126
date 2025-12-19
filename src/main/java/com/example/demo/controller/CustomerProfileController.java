package com.example.demo.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.CustomerProfile;
import com.example.demo.service.CustomerProfileService;

@RestController
@RequestMapping("/api/customers")
public class CustomerProfileController {

    private final CustomerProfileService customerProfileService;

    public CustomerProfileController(CustomerProfileService customerProfileService) {
        this.customerProfileService = customerProfileService;
    }

    @PostMapping
    public CustomerProfile create(@Valid @RequestBody CustomerProfile customer) {
        return customerProfileService.createCustomer(customer);
    }

    @GetMapping("/{id}")
    public CustomerProfile getById(@PathVariable Long id) {
        return customerProfileService.getCustomerById(id);
    }

    @GetMapping
    public List<CustomerProfile> getAll() {
        return customerProfileService.getAllCustomers();
    }

    @PutMapping("/{id}/tier")
    public CustomerProfile updateTier(
            @PathVariable Long id,
            @RequestParam String tier) {
        return customerProfileService.updateTier(id, tier);
    }

    @PutMapping("/{id}/status")
    public CustomerProfile updateStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {
        return customerProfileService.updateStatus(id, active);
    }
}
