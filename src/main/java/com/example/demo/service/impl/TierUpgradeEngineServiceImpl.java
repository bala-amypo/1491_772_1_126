package com.example.demo.service.impl;

import com.example.demo.model.CustomerProfile;
import com.example.demo.model.TierHistoryRecord;
import com.example.demo.model.TierUpgradeRule;
import com.example.demo.repository.CustomerProfileRepository;
import com.example.demo.repository.TierHistoryRecordRepository;
import com.example.demo.repository.TierUpgradeRuleRepository;
import com.example.demo.service.TierUpgradeEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TierUpgradeEngineServiceImpl implements TierUpgradeEngineService {

    @Autowired
    private CustomerProfileRepository customerRepo;

    @Autowired
    private TierUpgradeRuleRepository ruleRepo;

    @Autowired
    private TierHistoryRecordRepository historyRepo;

    @Override
    public void evaluateAndUpgradeTier(Long customerId) {
        CustomerProfile customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        // Get all active rules
        List<TierUpgradeRule> rules = ruleRepo.findByActive(true);

        for (TierUpgradeRule rule : rules) {
            if (customer.getPoints() >= rule.getPointsRequired() &&
                customer.getVisits() >= rule.getVisitsRequired() &&
                customer.getCurrentTier().equals(rule.getCurrentTier())) {

                String oldTier = customer.getCurrentTier();
                customer.setCurrentTier(rule.getNextTier());
                customerRepo.save(customer);

                // Save history record
                TierHistoryRecord record = new TierHistoryRecord(
                        null, customer, oldTier, rule.getNextTier(), "UPGRADED", LocalDateTime.now()
                );
                historyRepo.save(record);
            }
        }
    }

    @Override
    public List<TierHistoryRecord> getHistoryByCustomer(Long customerId) {
        CustomerProfile customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return historyRepo.findByCustomer(customer);
    }

    @Override
    public List<TierHistoryRecord> getAllHistory() {
        return historyRepo.findAll();
    }
}
