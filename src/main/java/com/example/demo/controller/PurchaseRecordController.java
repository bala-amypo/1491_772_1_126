package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.PurchaseRecord;
import com.example.demo.service.PurchaseRecordService;

@RestController
@RequestMapping("/purchases")
public class PurchaseRecordController {

    private final PurchaseRecordService purchaseService;

    public PurchaseRecordController(PurchaseRecordService purchaseService) {
        this.purchaseService = purchaseService;
    }

    // Record purchase
    @PostMapping
    public PurchaseRecord recordPurchase(
            @RequestBody PurchaseRecord purchase) {
        return purchaseService.recordPurchase(purchase);
    }

    // Get purchase by id
    @GetMapping("/{id}")
    public PurchaseRecord getPurchaseById(@PathVariable Long id) {
        return purchaseService.getPurchaseById(id);
    }

    // Get purchases by customer
    @GetMapping("/customer/{customerId}")
    public List<PurchaseRecord> getPurchasesByCustomer(
            @PathVariable Long customerId) {
        return purchaseService.getPurchasesByCustomer(customerId);
    }

    // Get all purchases
    @GetMapping
    public List<PurchaseRecord> getAllPurchases() {
        return purchaseService.getAllPurchases();
    }
}
