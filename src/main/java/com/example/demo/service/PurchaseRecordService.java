package com.example.demo.service;

import com.example.demo.entity.PurchaseRecord;
import com.example.demo.repository.PurchaseRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseRecordService {

    @Autowired
    private PurchaseRecordRepository repository;

    public void recordPurchase(PurchaseRecord purchase) {
        if (purchase.getAmount() <= 0) throw new IllegalArgumentException("Amount must be > 0");
        repository.save(purchase);
    }

    public List<PurchaseRecord> getPurchasesByCustomer(Long customerId) {
        return repository.findByCustomerId(customerId);
    }

    public PurchaseRecord getPurchasesById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<PurchaseRecord> getAllPurchases() {
        return repository.findAll();
    }
}
