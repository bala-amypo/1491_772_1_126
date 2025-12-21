package com.example.demo.service.impl;

import com.example.demo.model.CustomerProfile;
import com.example.demo.model.TierHistoryRecord;
import com.example.demo.model.TierUpgradeRule;
import com.example.demo.repository.TierHistoryRecordRepository;
import com.example.demo.repository.TierUpgradeRuleRepository;
import com.example.demo.service.TierUpgradeEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TierUpgradeEngineServiceImpl implements TierUpgradeEngineService {

    @Autowired
    private TierUpgradeRuleRepository ruleRepo;

    @Autowired
    private TierHistoryRecordRepository historyRepo;

    @Override
    public void evaluateAndUpgradeTier(CustomerProfile customer) {
        List<TierUpgradeRule> activeRules = ruleRepo.findByActive(true);

        for (TierUpgradeRule rule : activeRules) {
            if (customer.getPoints() >= rule.getPointsRequired() &&
                customer.getVisits() >= rule.getVisitsRequired() &&
                customer.getCurrentTier().equals(rule.getCurrentTier())) {

                String oldTier = customer.getCurrentTier();
                customer.setCurrentTier(rule.getNextTier());

                TierHistoryRecord record = new TierHistoryRecord(customer, oldTier, rule.getNextTier(), "UPGRADE");
                historyRepo.save(record);

                break; // Upgrade only once per evaluation
            }
        }
    }

    @Override
    public List<TierHistoryRecord> getHistoryByCustomer(CustomerProfile customer) {
        return historyRepo.findByCustomer(customer);
    }

    @Override
    public List<TierHistoryRecord> getAllHistory() {
        return historyRepo.findAll();
    }
}
