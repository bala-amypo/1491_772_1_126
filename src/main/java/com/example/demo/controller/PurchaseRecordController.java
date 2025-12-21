package com.example.demo.controller;

import com.example.demo.entity.PurchaseRecord;
import com.example.demo.service.PurchaseRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchases")
public class PurchaseRecordController {

    private final PurchaseRecordService purchaseRecordService;

    public PurchaseRecordController(PurchaseRecordService purchaseRecordService) {
        this.purchaseRecordService = purchaseRecordService;
    }

    @PostMapping
    public PurchaseRecord recordPurchase(@RequestBody PurchaseRecord purchase) {
        return purchaseRecordService.recordPurchase(purchase);
    }

    @GetMapping("/customer/{customerId}")
    public List<PurchaseRecord> getPurchasesByCustomer(@PathVariable Long customerId) {
        return purchaseRecordService.getPurchasesByCustomer(customerId);
    }

    @GetMapping("/{id}")
    public PurchaseRecord getPurchaseById(@PathVariable Long id) {
        return purchaseRecordService.getPurchaseById(id);
    }

    @GetMapping
    public List<PurchaseRecord> getAllPurchases() {
        return purchaseRecordService.getAllPurchases();
    }
}
