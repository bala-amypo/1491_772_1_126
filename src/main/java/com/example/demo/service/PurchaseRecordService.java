package com.example.demo.service;

import com.example.demo.model.PurchaseRecord;
import java.util.List;

public interface PurchaseRecordService {
    PurchaseRecord createPurchase(PurchaseRecord purchase);
    PurchaseRecord getPurchaseById(Long id);
    List<PurchaseRecord> getAllPurchases();
}
