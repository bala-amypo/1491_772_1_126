package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.demo.model.VisitRecord;
import com.example.demo.repository.VisitRecordRepository;
import com.example.demo.service.VisitRecordService;

@Service
public class VisitRecordServiceImpl implements VisitRecordService {

    private final VisitRecordRepository repo;

    private static final Set<String> VALID_CHANNELS =
            Set.of("STORE", "APP", "WEB");

    public VisitRecordServiceImpl(VisitRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public VisitRecord recordVisit(VisitRecord visit) {
        if (!VALID_CHANNELS.contains(visit.getChannel())) {
            throw new IllegalArgumentException("Invalid channel");
        }
        return repo.save(visit);
    }

    @Override
    public Optional<VisitRecord> getVisitById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<VisitRecord> getVisitsByCustomer(Long customerId) {
        return repo.findByCustomerId(customerId);
    }

    @Override
    public List<VisitRecord> getAllVisits() {
        return repo.findAll();
    }
}
