package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.VisitRecord;
import com.example.demo.service.VisitRecordService;

@RestController
@RequestMapping("/visit")
public class VisitRecordController {

    @Autowired
    private VisitRecordService service;

    @PostMapping
    public VisitRecord save(@RequestBody VisitRecord v) {
        return service.save(v);
    }
}
