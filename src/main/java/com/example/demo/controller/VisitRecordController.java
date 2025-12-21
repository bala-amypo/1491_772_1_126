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

    @PostMapping
    public VisitRecord recordVisit(@RequestBody VisitRecord visit) {
        return visitService.recordVisit(visit);
    }

    @GetMapping("/{id}")
    public VisitRecord getVisit(@PathVariable Long id) {
        return visitService.getVisitById(id);
    }

    @GetMapping("/customer/{customerId}")
    public List<VisitRecord> getByCustomer(@PathVariable Long customerId) {
        return visitService.getVisitsByCustomer(customerId);
    }

    @GetMapping
    public List<VisitRecord> getAllVisits() {
        return visitService.getAllVisits();
    }
}
