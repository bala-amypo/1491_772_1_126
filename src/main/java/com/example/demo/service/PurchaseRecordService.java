package com.example.demo.service;

import java.util.List;

import com.example.demo.model.PurchaseRecord;

public interface PurchaseRecordService {

    PurchaseRecord recordPurchase(PurchaseRecord purchase);

    PurchaseRecord getPurchaseById(Long id);

    List<PurchaseRecord> getPurchasesByCustomer(Long customerId);

    List<PurchaseRecord> getAllPurchases();
}
