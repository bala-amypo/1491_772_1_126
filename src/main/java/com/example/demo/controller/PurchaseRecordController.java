package com.example.demo.controller;

import com.example.demo.model.PurchaseRecord;
import com.example.demo.model.CustomerProfile;
import com.example.demo.service.PurchaseRecordService;
import com.example.demo.service.CustomerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchases")
public class PurchaseRecordController {

    @Autowired
    private PurchaseRecordService service;

    @Autowired
    private CustomerProfileService customerService;

    @PostMapping("/{customerId}")
    public PurchaseRecord recordPurchase(@PathVariable String customerId, @RequestBody PurchaseRecord purchase) {
        CustomerProfile customer = customerService.getCustomerByCustomerId(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        purchase.setCustomer(customer);
        return service.recordPurchase(purchase);
    }

    @GetMapping("/{customerId}")
    public List<PurchaseRecord> getPurchasesByCustomer(@PathVariable String customerId) {
        CustomerProfile customer = customerService.getCustomerByCustomerId(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return service.getPurchasesByCustomer(customer);
    }
}
