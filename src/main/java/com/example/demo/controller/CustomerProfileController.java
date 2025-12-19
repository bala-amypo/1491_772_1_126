package com.example.demo.controller;

import java.util.List;

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

    // POST /api/customers
    @PostMapping
    public CustomerProfile createCustomer(@RequestBody CustomerProfile customer) {
        return customerProfileService.createCustomer(customer);
    }

    // GET /api/customers/{id}
    @GetMapping("/{id}")
    public CustomerProfile getCustomerById(@PathVariable Long id) {
        return customerProfileService.getCustomerById(id);
    }

    // GET /api/customers
    @GetMapping
    public List<CustomerProfile> getAllCustomers() {
        return customerProfileService.getAllCustomers();
    }

    // PUT /api/customers/{id}/tier?newTier=GOLD
    @PutMapping("/{id}/tier")
    public CustomerProfile updateTier(
            @PathVariable Long id,
            @RequestParam String newTier) {

        return customerProfileService.updateTier(id, newTier);
    }

    // GET /api/customers/lookup/{customerId}
    @GetMapping("/lookup/{customerId}")
    public CustomerProfile findByCustomerId(@PathVariable String customerId) {
        return customerProfileService.findByCustomerId(customerId);
    }
}
