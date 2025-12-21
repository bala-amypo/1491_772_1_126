package com.example.demo.service.impl;

import com.example.demo.model.VisitRecord;
import com.example.demo.repository.VisitRecordRepository;

import java.util.List;
import java.util.NoSuchElementException;

public class VisitRecordServiceImpl implements VisitRecordService {

    private final VisitRecordRepository visitRecordRepository;

    public VisitRecordServiceImpl(VisitRecordRepository visitRecordRepository) {
        this.visitRecordRepository = visitRecordRepository;
    }

    @Override
    public VisitRecord recordVisit(VisitRecord visit) {
        List<String> validChannels = List.of("STORE", "APP", "WEB");
        if (!validChannels.contains(visit.getChannel())) {
            throw new IllegalArgumentException("Invalid channel");
        }
        return visitRecordRepository.save(visit);
    }

    @Override
    public List<VisitRecord> getVisitsByCustomer(Long customerId) {
        return visitRecordRepository.findByCustomerId(customerId);
    }

    @Override
    public List<VisitRecord> getAllVisits() {
        return visitRecordRepository.findAll();
    }

    @Override
    public VisitRecord getVisitById(Long id) {
        return visitRecordRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Visit record not found"));
    }
}
