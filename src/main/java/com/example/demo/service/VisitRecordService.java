package com.example.demo.service;

import com.example.demo.model.VisitRecord;
import java.util.List;

public interface VisitRecordService {
    VisitRecord createVisit(VisitRecord visit);
    VisitRecord getVisitById(Long id);
    List<VisitRecord> getAllVisits();
}
