package com.example.demo.controller;

import com.example.demo.model.VisitRecord;
import com.example.demo.model.CustomerProfile;
import com.example.demo.service.VisitRecordService;
import com.example.demo.service.CustomerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visits")
public class VisitRecordController {

    @Autowired
    private VisitRecordService service;

    @Autowired
    private CustomerProfileService customerService;

    @PostMapping("/{customerId}")
    public VisitRecord recordVisit(@PathVariable String customerId, @RequestBody VisitRecord visit) {
        CustomerProfile customer = customerService.getCustomerByCustomerId(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        visit.setCustomer(customer);
        return service.recordVisit(visit);
    }

    @GetMapping("/{customerId}")
    public List<VisitRecord> getVisitsByCustomer(@PathVariable String customerId) {
        CustomerProfile customer = customerService.getCustomerByCustomerId(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return service.getVisitsByCustomer(customer);
    }
}
