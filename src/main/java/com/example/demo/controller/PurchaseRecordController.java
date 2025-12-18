package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.PurchaseRecord;
import com.example.demo.service.PurchaseRecordService;

@RestController
@RequestMapping("/purchase")
public class PurchaseRecordController {

    @Autowired
    private PurchaseRecordService service;

    @PostMapping
    public PurchaseRecord save(@RequestBody PurchaseRecord p) {
        return service.save(p);
    }
}
