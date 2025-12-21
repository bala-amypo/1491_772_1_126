package com.example.demo.controller;

import com.example.demo.model.PurchaseRecord;
import com.example.demo.service.PurchaseRecordService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/purchases")
public class PurchaseRecordController {

    private final PurchaseRecordService service;

    public PurchaseRecordController(PurchaseRecordService service) {
        this.service = service;
    }

    @PostMapping
    public PurchaseRecord recordPurchase(@RequestBody PurchaseRecord purchase) {
        return service.recordPurchase(purchase);
    }

    @GetMapping("/customer/{id}")
    public List<PurchaseRecord> getPurchasesByCustomer(@PathVariable Long id) {
        return service.getPurchasesByCustomer(id);
    }
}
