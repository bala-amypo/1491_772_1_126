package com.example.demo.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.demo.model.VisitRecord;
import com.example.demo.repository.VisitRecordRepository;
import com.example.demo.service.VisitRecordService;

@Service
public class VisitRecordServiceImpl implements VisitRecordService {

    private final VisitRecordRepository visitRepo;

    private static final Set<String> VALID_CHANNELS =
            Set.of("STORE", "APP", "WEB");

    public VisitRecordServiceImpl(VisitRecordRepository visitRepo) {
        this.visitRepo = visitRepo;
    }

    @Override
    public VisitRecord recordVisit(VisitRecord visit) {
        if (!VALID_CHANNELS.contains(visit.getChannel())) {
            throw new IllegalArgumentException("Invalid channel");
        }
        return visitRepo.save(visit);
    }

    @Override
    public VisitRecord getVisitById(Long id) {
        return visitRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Visit record not found"));
    }

    @Override
    public List<VisitRecord> getVisitsByCustomer(Long customerId) {
        return visitRepo.findByCustomerId(customerId);
    }

    @Override
    public List<VisitRecord> getAllVisits() {
        return visitRepo.findAll();
    }
}
