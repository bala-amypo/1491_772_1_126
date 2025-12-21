package com.example.demo.repository;

import com.example.demo.model.PurchaseRecord;
import com.example.demo.model.CustomerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRecordRepository extends JpaRepository<PurchaseRecord, Long> {
    List<PurchaseRecord> findByCustomer(CustomerProfile customer);
}
