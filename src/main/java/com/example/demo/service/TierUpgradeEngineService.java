package com.example.demo.service;

import com.example.demo.model.TierHistoryRecord;
import com.example.demo.model.CustomerProfile;

import java.util.List;

public interface TierUpgradeEngineService {
    void evaluateAndUpgradeTier(Long customerId);
    List<TierHistoryRecord> getHistoryByCustomer(Long customerId);
    List<TierHistoryRecord> getAllHistory();
}
