package com.example.demo.service;

import com.example.demo.entity.VisitRecord;
import com.example.demo.repository.VisitRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitRecordService {

    @Autowired
    private VisitRecordRepository repository;

    public void recordVisit(VisitRecord visit) {
        repository.save(visit);
    }

    public List<VisitRecord> getVisitsByCustomer(Long customerId) {
        return repository.findByCustomerId(customerId);
    }

    public VisitRecord getVisitById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<VisitRecord> getAllVisits() {
        return repository.findAll();
    }
}
