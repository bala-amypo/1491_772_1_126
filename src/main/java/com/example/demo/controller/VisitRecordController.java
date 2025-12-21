package com.example.demo.controller;

import com.example.demo.model.VisitRecord;
import com.example.demo.service.VisitRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visits")
public class VisitRecordController {

    private final VisitRecordService visitRecordService;

    public VisitRecordController(VisitRecordService visitRecordService) {
        this.visitRecordService = visitRecordService;
    }

    @PostMapping
    public VisitRecord recordVisit(@RequestBody VisitRecord visit) {
        return visitRecordService.recordVisit(visit);
    }

    @GetMapping("/customer/{customerId}")
    public List<VisitRecord> getVisitsByCustomer(@PathVariable Long customerId) {
        return visitRecordService.getVisitsByCustomer(customerId);
    }

    @GetMapping("/{id}")
    public VisitRecord getVisitById(@PathVariable Long id) {
        return visitRecordService.getVisitById(id);
    }

    @GetMapping
    public List<VisitRecord> getAllVisits() {
        return visitRecordService.getAllVisits();
    }
}
