package com.example.demo.controller;

import com.example.demo.entity.PurchaseRecord;
import com.example.demo.service.PurchaseRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/purchases")
public class PurchaseRecordController {

    private final PurchaseRecordService purchaseRecordService;

    @Autowired
    public PurchaseRecordController(PurchaseRecordService purchaseRecordService) {
        this.purchaseRecordService = purchaseRecordService;
    }

    @PostMapping
    public void recordPurchase(@RequestBody PurchaseRecord purchase) {
        purchaseRecordService.recordPurchase(purchase);
    }

    @GetMapping("/customer/{customerId}")
    public Iterable<PurchaseRecord> getPurchasesByCustomer(@PathVariable Long customerId) {
        return purchaseRecordService.getPurchasesByCustomer(customerId);
    }

    @GetMapping("/{id}")
    public PurchaseRecord getPurchaseById(@PathVariable Long id) {
        return purchaseRecordService.getPurchasesById(id);
    }

    @GetMapping
    public Iterable<PurchaseRecord> getAllPurchases() {
        return purchaseRecordService.getAllPurchases();
    }
}
