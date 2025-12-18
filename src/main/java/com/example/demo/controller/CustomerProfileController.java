package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.CustomerProfile;
import com.example.demo.service.CustomerProfileService;

@RestController
@RequestMapping("/customers")
public class CustomerProfileController {

    @Autowired
    private CustomerProfileService service;

    @PostMapping
    public CustomerProfile save(@RequestBody CustomerProfile c) {
        return service.save(c);
    }

    @GetMapping
    public List<CustomerProfile> getAll() {
        return service.getAll();
    }
}
