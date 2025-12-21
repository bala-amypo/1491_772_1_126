package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.model.CustomerProfile;
import com.example.demo.service.CustomerProfileService;

@RestController
@RequestMapping("/customers")
public class CustomerProfileController {

    private final CustomerProfileService service;

    public CustomerProfileController(CustomerProfileService service) {
        this.service = service;
    }

    @GetMapping("/lookup/{customerId}")
    public CustomerProfile getByCustomerId(@PathVariable String customerId) {
        return service.findByCustomerId(customerId);
    }
}
