package com.example.demo.service;

import com.example.demo.entity.VisitRecord;

import java.util.List;

public interface VisitRecordService {

    VisitRecord recordVisit(VisitRecord visit);

    List<VisitRecord> getVisitsByCustomer(Long id);

    List<VisitRecord> getAllVisits();

    VisitRecord getVisitById(Long id);
}
