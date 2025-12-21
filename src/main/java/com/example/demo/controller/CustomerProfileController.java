package com.example.demo.controller;

import com.example.demo.model.CustomerProfile;
import com.example.demo.service.CustomerProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/customers")
public class CustomerProfileController {

    private final CustomerProfileService customerProfileService;

    public CustomerProfileController(CustomerProfileService customerProfileService) {
        this.customerProfileService = customerProfileService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<CustomerProfile> createCustomer(@RequestBody CustomerProfile customer) {
        return ResponseEntity.ok(customerProfileService.createCustomer(customer));
    }

    // READ
    @GetMapping("/{id}")
    public ResponseEntity<CustomerProfile> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(customerProfileService.getCustomerById(id));
    }

    @GetMapping("/byCustomerId/{customerId}")
    public ResponseEntity<CustomerProfile> getByCustomerId(@PathVariable String customerId) {
        return ResponseEntity.ok(customerProfileService.findByCustomerId(customerId));
    }

    @GetMapping
    public ResponseEntity<List<CustomerProfile>> getAllCustomers() {
        return ResponseEntity.ok(customerProfileService.getAllCustomers());
    }

    // UPDATE
    @PatchMapping("/{id}/tier")
    public ResponseEntity<CustomerProfile> updateTier(@PathVariable Long id, @RequestParam String tier) {
        return ResponseEntity.ok(customerProfileService.updateTier(id, tier));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<CustomerProfile> updateStatus(@PathVariable Long id, @RequestParam boolean active) {
        return ResponseEntity.ok(customerProfileService.updateStatus(id, active));
    }

    // Exception handling
    @ExceptionHandler({IllegalArgumentException.class, NoSuchElementException.class})
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
