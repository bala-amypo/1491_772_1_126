package com.example.demo.repository;

import com.example.demo.model.VisitRecord;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface VisitRecordRepository {

    VisitRecord save(VisitRecord visit);

    Optional<VisitRecord> findById(Long id);

    List<VisitRecord> findAll();

    List<VisitRecord> findByCustomerId(Long customerId);

    List<VisitRecord> findByVisitDateBetween(LocalDate start, LocalDate end);
}
