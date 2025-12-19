package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.CustomerProfile;
import com.example.demo.service.CustomerProfileService;

@RestController
@RequestMapping("/customer")
public class CustomerProfileController {

    @Autowired
    private CustomerProfileService service;
@PostMapping("/customer")
public CustomerProfile addCustomer(@RequestBody CustomerProfile cp) {
    return service.insertCustomerProfile(cp); // matches interface
}

@GetMapping("/customers")
public List<CustomerProfile> getAllCustomers() {
    return service.getAll(); // matches interface
}

@GetMapping("/customer/{id}")
public CustomerProfile getCustomer(@PathVariable Long id) {
    return service.getById(id).orElse(null); // matches interface
}

@DeleteMapping("/customer/{id}")
public void deleteCustomer(@PathVariable Long id) {
    service.deleteCustomerProfile(id); // matches interface
}

}
