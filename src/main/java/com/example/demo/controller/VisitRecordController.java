package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.VisitRecord;
import com.example.demo.service.VisitRecordService;

@RestController
@RequestMapping("/visits")
public class VisitRecordController {

    private final VisitRecordService visitService;

    public VisitRecordController(VisitRecordService visitService) {
        this.visitService = visitService;
    }

    // Record visit
    @PostMapping
    public VisitRecord recordVisit(@RequestBody VisitRecord visit) {
        return visitService.recordVisit(visit);
    }

    // Get visit by id
    @GetMapping("/{id}")
    public VisitRecord getVisitById(@PathVariable Long id) {
        return visitService.getVisitById(id);
    }

    // Get visits by customer
    @GetMapping("/customer/{customerId}")
    public List<VisitRecord> getVisitsByCustomer(
            @PathVariable Long customerId) {
        return visitService.getVisitsByCustomer(customerId);
    }

    // Get all visits
    @GetMapping
    public List<VisitRecord> getAllVisits() {
        return visitService.getAllVisits();
    }
}
