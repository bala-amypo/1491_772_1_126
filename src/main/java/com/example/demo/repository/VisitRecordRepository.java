package com.example.demo.repository;

import com.example.demo.model.VisitRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VisitRecordRepository extends JpaRepository<VisitRecord, Long> {

    // Extra methods
    List<VisitRecord> findByCustomerId(Long customerId);

    List<VisitRecord> findByVisitDateBetween(LocalDate start, LocalDate end);
}
