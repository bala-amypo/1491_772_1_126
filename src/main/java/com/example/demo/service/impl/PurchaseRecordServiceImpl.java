package com.example.demo.service.impl;

import com.example.demo.model.PurchaseRecord;
import com.example.demo.model.CustomerProfile;
import com.example.demo.repository.PurchaseRecordRepository;
import com.example.demo.service.PurchaseRecordService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseRecordServiceImpl implements PurchaseRecordService {

    private final PurchaseRecordRepository repository;

    public PurchaseRecordServiceImpl(PurchaseRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public PurchaseRecord recordPurchase(PurchaseRecord purchase) {
        return repository.save(purchase);
    }

    @Override
    public List<PurchaseRecord> getPurchasesByCustomer(CustomerProfile customer) {
        return repository.findByCustomer(customer);
    }

    @Override
    public Optional<PurchaseRecord> getPurchaseById(Long id) {
        return repository.findById(id);
    }
}
