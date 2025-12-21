package com.example.demo.controller;

import com.example.demo.model.VisitRecord;
import com.example.demo.service.VisitRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visits")
public class VisitRecordController {

    @Autowired
    private VisitRecordService service;

    @PostMapping
    public VisitRecord recordVisit(@RequestBody VisitRecord visit) {
        return service.recordVisit(visit);
    }

    @GetMapping("/customer/{customerId}")
    public List<VisitRecord> getVisitsByCustomer(@PathVariable Long customerId) {
        return service.getVisitsByCustomer(customerId);
    }
}
