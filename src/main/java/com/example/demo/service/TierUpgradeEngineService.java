package com.example.demo.service;

import com.example.demo.model.TierHistoryRecord;

public interface TierUpgradeEngineService {
    TierHistoryRecord recordTierUpgrade(Long customerId, String oldTier, String newTier, String reason);
}
