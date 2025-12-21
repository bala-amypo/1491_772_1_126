package com.example.demo.controller;

import com.example.demo.entity.CustomerProfile;
import com.example.demo.service.CustomerProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerProfileController {

    private final CustomerProfileService customerProfileService;

    public CustomerProfileController(CustomerProfileService customerProfileService) {
        this.customerProfileService = customerProfileService;
    }

    @PostMapping
    public CustomerProfile createCustomer(@RequestBody CustomerProfile customer) {
        return customerProfileService.createCustomer(customer);
    }

    @GetMapping("/{id}")
    public CustomerProfile getCustomerById(@PathVariable Long id) {
        return customerProfileService.getCustomerById(id);
    }

    @GetMapping("/by-customer-id/{customerId}")
    public CustomerProfile getByCustomerId(@PathVariable String customerId) {
        return customerProfileService.findByCustomerId(customerId);
    }

    @GetMapping
    public List<CustomerProfile> getAllCustomers() {
        return customerProfileService.getAllCustomers();
    }

    @PutMapping("/{id}/tier")
    public CustomerProfile updateTier(@PathVariable Long id,
                                      @RequestParam String tier) {
        return customerProfileService.updateTier(id, tier);
    }

    @PutMapping("/{id}/status")
    public CustomerProfile updateStatus(@PathVariable Long id,
                                        @RequestParam boolean active) {
        return customerProfileService.updateStatus(id, active);
    }
}
