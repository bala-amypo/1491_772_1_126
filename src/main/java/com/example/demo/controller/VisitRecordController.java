package com.example.demo.controller;

import com.example.demo.entity.VisitRecord;
import com.example.demo.service.VisitRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/visits")
public class VisitRecordController {

    private final VisitRecordService visitRecordService;

    @Autowired
    public VisitRecordController(VisitRecordService visitRecordService) {
        this.visitRecordService = visitRecordService;
    }

    @PostMapping
    public void recordVisit(@RequestBody VisitRecord visit) {
        visitRecordService.recordVisit(visit);
    }

    @GetMapping("/customer/{customerId}")
    public Iterable<VisitRecord> getVisitsByCustomer(@PathVariable Long customerId) {
        return visitRecordService.getVisitsByCustomer(customerId);
    }

    @GetMapping("/{id}")
    public VisitRecord getVisitById(@PathVariable Long id) {
        return visitRecordService.getVisitById(id);
    }

    @GetMapping
    public Iterable<VisitRecord> getAllVisits() {
        return visitRecordService.getAllVisits();
    }
}
