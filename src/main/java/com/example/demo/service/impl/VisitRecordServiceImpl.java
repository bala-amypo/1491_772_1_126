package com.example.demo.service.impl;

import com.example.demo.model.VisitRecord;
import com.example.demo.model.CustomerProfile;
import com.example.demo.repository.VisitRecordRepository;
import com.example.demo.service.VisitRecordService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitRecordServiceImpl implements VisitRecordService {

    private final VisitRecordRepository repository;

    public VisitRecordServiceImpl(VisitRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public VisitRecord recordVisit(VisitRecord visit) {
        return repository.save(visit);
    }

    @Override
    public List<VisitRecord> getVisitsByCustomer(CustomerProfile customer) {
        return repository.findByCustomer(customer);
    }

    @Override
    public Optional<VisitRecord> getVisitById(Long id) {
        return repository.findById(id);
    }
}
