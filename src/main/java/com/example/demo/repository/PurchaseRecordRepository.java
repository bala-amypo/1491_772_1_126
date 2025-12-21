package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.PurchaseRecord;

public interface PurchaseRecordRepository
        extends JpaRepository<PurchaseRecord, Long> {

    List<PurchaseRecord> findByCustomerId(Long customerId);

    List<PurchaseRecord> findByPurchaseDateBetween(
            LocalDate startDate, LocalDate endDate);
}
