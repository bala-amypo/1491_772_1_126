package com.example.demo.service.impl;

import com.example.demo.model.PurchaseRecord;
import com.example.demo.model.CustomerProfile;
import com.example.demo.repository.PurchaseRecordRepository;
import com.example.demo.service.PurchaseRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseRecordServiceImpl implements PurchaseRecordService {

    @Autowired
    private PurchaseRecordRepository repository;

    @Override
    public PurchaseRecord recordPurchase(PurchaseRecord purchase) {
        return repository.save(purchase);
    }

    @Override
    public List<PurchaseRecord> getPurchasesByCustomer(CustomerProfile customer) {
        return repository.findByCustomer(customer);
    }
}
