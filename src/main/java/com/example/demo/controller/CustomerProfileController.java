package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.CustomerProfile;
import com.example.demo.service.CustomerProfileService;

@RestController
public class CustomerProfileController {

    @Autowired
    CustomerProfileService customerProfileService;

    @PostMapping("/addcustomer")
    public CustomerProfile add(@RequestBody CustomerProfile cp) {
        return customerProfileService.createCustomer(cp);
    }

    @GetMapping("/showcustomer")
    public List<CustomerProfile> show() {
        return customerProfileService.getAllCustomers();
    }
}
