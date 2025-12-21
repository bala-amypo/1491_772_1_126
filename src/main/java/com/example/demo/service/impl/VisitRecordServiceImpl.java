package com.example.demo.service.impl;

import com.example.demo.model.VisitRecord;
import com.example.demo.model.CustomerProfile;
import com.example.demo.repository.VisitRecordRepository;
import com.example.demo.service.VisitRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitRecordServiceImpl implements VisitRecordService {

    @Autowired
    private VisitRecordRepository repository;

    @Override
    public VisitRecord recordVisit(VisitRecord visit) {
        return repository.save(visit);
    }

    @Override
    public List<VisitRecord> getVisitsByCustomer(CustomerProfile customer) {
        return repository.findByCustomer(customer);
    }
}
