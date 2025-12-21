package com.example.demo.service;

import com.example.demo.model.PurchaseRecord;
import com.example.demo.model.CustomerProfile;

import java.util.List;
import java.util.Optional;

public interface PurchaseRecordService {
    PurchaseRecord recordPurchase(PurchaseRecord purchase);
    List<PurchaseRecord> getPurchasesByCustomer(CustomerProfile customer);
    Optional<PurchaseRecord> getPurchaseById(Long id);
}
