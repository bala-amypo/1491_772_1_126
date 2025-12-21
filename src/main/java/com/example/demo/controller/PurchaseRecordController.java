package com.example.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

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

    @PostMapping
    public PurchaseRecord recordPurchase(@RequestBody PurchaseRecord purchase) {
        return purchaseService.recordPurchase(purchase);
    }

    @GetMapping("/{id}")
    public PurchaseRecord getPurchaseById(@PathVariable Long id) {
        return purchaseService.getPurchaseById(id)
                .orElseThrow(() -> new NoSuchElementException("Purchase record not found"));
    }

    @GetMapping("/customer/{customerId}")
    public List<PurchaseRecord> getPurchasesByCustomer(
            @PathVariable Long customerId) {
        return purchaseService.getPurchasesByCustomer(customerId);
    }

    @GetMapping
    public List<PurchaseRecord> getAllPurchases() {
        return purchaseService.getAllPurchases();
    }
}
