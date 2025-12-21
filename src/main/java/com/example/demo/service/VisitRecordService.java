package com.example.demo.service;

import java.util.List;

import com.example.demo.model.VisitRecord;

public interface VisitRecordService {

    VisitRecord recordVisit(VisitRecord visit);

    VisitRecord getVisitById(Long id);

    List<VisitRecord> getVisitsByCustomer(Long customerId);

    List<VisitRecord> getAllVisits();
}
