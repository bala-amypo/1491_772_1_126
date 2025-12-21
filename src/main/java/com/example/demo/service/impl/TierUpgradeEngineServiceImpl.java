package com.example.demo.service.impl;

import com.example.demo.model.CustomerProfile;
import com.example.demo.model.TierHistoryRecord;
import com.example.demo.repository.TierHistoryRecordRepository;
import com.example.demo.service.CustomerProfileService;
import com.example.demo.service.TierUpgradeEngineService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TierUpgradeEngineServiceImpl implements TierUpgradeEngineService {

    private final TierHistoryRecordRepository historyRepository;
    private final CustomerProfileService customerService;

    public TierUpgradeEngineServiceImpl(TierHistoryRecordRepository historyRepository, CustomerProfileService customerService) {
        this.historyRepository = historyRepository;
        this.customerService = customerService;
    }

    @Override
    public TierHistoryRecord recordTierUpgrade(Long customerId, String oldTier, String newTier, String reason) {
        CustomerProfile customer = customerService.getCustomerById(customerId);
        TierHistoryRecord record = new TierHistoryRecord(customer, oldTier, newTier, reason);
        record.setCreatedAt(LocalDateTime.now());
        return historyRepository.save(record);
    }
}
