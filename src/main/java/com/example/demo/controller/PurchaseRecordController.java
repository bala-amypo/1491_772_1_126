package com.example.demo.controller;

import com.example.demo.model.PurchaseRecord;
import com.example.demo.model.CustomerProfile;
import com.example.demo.service.PurchaseRecordService;
import com.example.demo.service.CustomerProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchases")
public class PurchaseRecordController {

    private final PurchaseRecordService service;
    private final CustomerProfileService customerService;

    public PurchaseRecordController(PurchaseRecordService service, CustomerProfileService customerService) {
        this.service = service;
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<PurchaseRecord> recordPurchase(@RequestBody PurchaseRecord purchase) {
        return ResponseEntity.ok(service.recordPurchase(purchase));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<PurchaseRecord>> getPurchasesByCustomer(@PathVariable String customerId) {
        CustomerProfile customer = customerService.getCustomerByCustomerId(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return ResponseEntity.ok(service.getPurchasesByCustomer(customer));
    }
}
