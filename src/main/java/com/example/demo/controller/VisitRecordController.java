package com.example.demo.controller;

import com.example.demo.model.VisitRecord;
import com.example.demo.model.CustomerProfile;
import com.example.demo.service.VisitRecordService;
import com.example.demo.service.CustomerProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visits")
public class VisitRecordController {

    private final VisitRecordService service;
    private final CustomerProfileService customerService;

    public VisitRecordController(VisitRecordService service, CustomerProfileService customerService) {
        this.service = service;
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<VisitRecord> recordVisit(@RequestBody VisitRecord visit) {
        return ResponseEntity.ok(service.recordVisit(visit));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<VisitRecord>> getVisitsByCustomer(@PathVariable String customerId) {
        CustomerProfile customer = customerService.getCustomerByCustomerId(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return ResponseEntity.ok(service.getVisitsByCustomer(customer));
    }
}
