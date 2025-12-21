package com.example.demo.controller;

import com.example.demo.model.VisitRecord;
import com.example.demo.service.VisitRecordService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/visits")
public class VisitRecordController {

    private final VisitRecordService service;

    public VisitRecordController(VisitRecordService service) {
        this.service = service;
    }

    @PostMapping
    public VisitRecord recordVisit(@RequestBody VisitRecord visit) {
        return service.recordVisit(visit);
    }

    @GetMapping("/customer/{id}")
    public List<VisitRecord> getVisitsByCustomer(@PathVariable Long id) {
        return service.getVisitsByCustomer(id);
    }
}
