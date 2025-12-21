package com.example.demo.repository;

import com.example.demo.model.TierHistoryRecord;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TierHistoryRecordRepository {

    TierHistoryRecord save(TierHistoryRecord record);

    Optional<TierHistoryRecord> findById(Long id);

    List<TierHistoryRecord> findAll();

    List<TierHistoryRecord> findByCustomerId(Long customerId);

    List<TierHistoryRecord> findByChangedAtBetween(LocalDateTime start, LocalDateTime end);
}
