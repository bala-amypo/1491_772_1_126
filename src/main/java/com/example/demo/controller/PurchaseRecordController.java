package com.example.demo.controller;

import com.example.demo.entity.PurchaseRecord;
import com.example.demo.service.PurchaseRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchases")
public class PurchaseRecordController {

    @Autowired
    private PurchaseRecordService service;

    @PostMapping
    public PurchaseRecord createPurchase(@RequestBody PurchaseRecord purchase) {
        service.recordPurchase(purchase);
        return purchase;
    }

    @GetMapping("/{customerId}")
    public List<PurchaseRecord> getPurchasesByCustomer(@PathVariable Long customerId) {
        return service.getPurchasesByCustomer(customerId);
    }

    @GetMapping
    public List<PurchaseRecord> getAllPurchases() {
        return service.getAllPurchases();
    }
}
