package com.example.demo.controller;

import com.example.demo.entity.VisitRecord;
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
    public VisitRecord createVisit(@RequestBody VisitRecord visit) {
        service.recordVisit(visit);
        return visit;
    }

    @GetMapping("/{customerId}")
    public List<VisitRecord> getVisitsByCustomer(@PathVariable Long customerId) {
        return service.getVisitsByCustomer(customerId);
    }

    @GetMapping
    public List<VisitRecord> getAllVisits() {
        return service.getAllVisits();
    }
}
