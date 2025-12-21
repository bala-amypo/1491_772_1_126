package com.example.demo.controller;

import com.example.demo.model.CustomerProfile;
import com.example.demo.service.CustomerProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerProfileController {

    private final CustomerProfileService service;

    public CustomerProfileController(CustomerProfileService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CustomerProfile> createCustomer(@RequestBody CustomerProfile customer) {
        return ResponseEntity.ok(service.createCustomer(customer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerProfile> getCustomer(@PathVariable Long id) {
        return service.getCustomerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<CustomerProfile> getAllCustomers() {
        return service.getAllCustomers();
    }

    @PutMapping("/{id}/tier")
    public ResponseEntity<CustomerProfile> updateTier(@PathVariable Long id, @RequestParam String tier) {
        return ResponseEntity.ok(service.updateTier(id, tier));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<CustomerProfile> updateStatus(@PathVariable Long id, @RequestParam boolean active) {
        return ResponseEntity.ok(service.updateStatus(id, active));
    }
}
