package com.example.demo.controller;

import com.example.demo.model.CustomerProfile;
import com.example.demo.service.CustomerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerProfileController {

    @Autowired
    private CustomerProfileService service;

    @PostMapping
    public CustomerProfile createCustomer(@RequestBody CustomerProfile customer) {
        return service.createCustomer(customer);
    }

    @GetMapping("/{id}")
    public Optional<CustomerProfile> getCustomerById(@PathVariable Long id) {
        return service.getCustomerById(id);
    }

    @GetMapping("/byCustomerId/{customerId}")
    public Optional<CustomerProfile> getCustomerByCustomerId(@PathVariable String customerId) {
        return service.getCustomerByCustomerId(customerId);
    }

    @GetMapping
    public List<CustomerProfile> getAllCustomers() {
        return service.getAllCustomers();
    }

    @PutMapping("/{id}")
    public CustomerProfile updateCustomer(@PathVariable Long id, @RequestBody CustomerProfile customer) {
        customer.setId(id);
        return service.updateCustomer(customer);
    }

    @PutMapping("/{id}/tier")
    public CustomerProfile updateTier(@PathVariable Long id, @RequestParam String tier) {
        return service.updateTier(id, tier);
    }

    @PutMapping("/{id}/status")
    public CustomerProfile updateStatus(@PathVariable Long id, @RequestParam boolean active) {
        return service.updateStatus(id, active);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        service.deleteCustomer(id);
    }
}
