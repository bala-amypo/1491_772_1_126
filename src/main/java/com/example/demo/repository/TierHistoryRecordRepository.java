package com.example.demo.repository;

import com.example.demo.entity.TierHistoryRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TierHistoryRecordRepository extends JpaRepository<TierHistoryRecord, Long> {
}
