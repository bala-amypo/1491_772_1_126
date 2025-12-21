package com.example.demo.repository;

import com.example.demo.model.CustomerProfile;
import com.example.demo.model.TierHistoryRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TierHistoryRecordRepository extends JpaRepository<TierHistoryRecord, Long> {

    List<TierHistoryRecord> findByCustomer(CustomerProfile customer);
}
