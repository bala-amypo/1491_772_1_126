package com.example.demo.service.impl;

import com.example.demo.model.VisitRecord;
import com.example.demo.repository.VisitRecordRepository;
import com.example.demo.service.VisitRecordService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class VisitRecordServiceImpl implements VisitRecordService {

    private final VisitRecordRepository repository;

    public VisitRecordServiceImpl(VisitRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public VisitRecord createVisit(VisitRecord visit) {
        return repository.save(visit);
    }

    @Override
    public VisitRecord getVisitById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Visit not found"));
    }

    @Override
    public List<VisitRecord> getAllVisits() {
        return repository.findAll();
    }
}
