package com.example.demo.service;

import com.example.demo.model.VisitRecord;
import com.example.demo.model.CustomerProfile;

import java.util.List;
import java.util.Optional;

public interface VisitRecordService {
    VisitRecord recordVisit(VisitRecord visit);
    List<VisitRecord> getVisitsByCustomer(CustomerProfile customer);
    Optional<VisitRecord> getVisitById(Long id);
}
