package com.example.demo.service.impl;

import com.example.demo.model.TierHistoryRecord;
import com.example.demo.model.CustomerProfile;
import com.example.demo.model.TierUpgradeRule;
import com.example.demo.repository.TierHistoryRecordRepository;
import com.example.demo.repository.CustomerProfileRepository;
import com.example.demo.repository.TierUpgradeRuleRepository;
import com.example.demo.service.TierUpgradeEngineService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TierUpgradeEngineServiceImpl implements TierUpgradeEngineService {

    private final CustomerProfileRepository customerRepo;
    private final TierUpgradeRuleRepository ruleRepo;
    private final TierHistoryRecordRepository historyRepo;

    public TierUpgradeEngineServiceImpl(CustomerProfileRepository customerRepo, TierUpgradeRuleRepository ruleRepo,
                                       TierHistoryRecordRepository historyRepo) {
        this.customerRepo = customerRepo;
        this.ruleRepo = ruleRepo;
        this.historyRepo = historyRepo;
    }

    @Override
    public void evaluateAndUpgradeTier(Long customerId) {
        CustomerProfile customer = customerRepo.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found"));
        List<TierUpgradeRule> rules = ruleRepo.findByActive(true);
        for (TierUpgradeRule rule : rules) {
            if (customer.getCurrentTier().equals(rule.getCurrentTier())
                && customer.getPoints() >= rule.getPointsRequired()
                && customer.getVisits() >= rule.getVisitsRequired()) {
                String oldTier = customer.getCurrentTier();
                customer.setCurrentTier(rule.getNextTier());
                customerRepo.save(customer);

                TierHistoryRecord history = new TierHistoryRecord(customer, oldTier, rule.getNextTier(), "UPGRADED");
                history.setCreatedAt(LocalDateTime.now());
                historyRepo.save(history);
                break;
            }
        }
    }

    @Override
    public List<TierHistoryRecord> getHistoryByCustomer(Long customerId) {
        CustomerProfile customer = customerRepo.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found"));
        return historyRepo.findByCustomer(customer);
    }

    @Override
    public List<TierHistoryRecord> getAllHistory() {
        return historyRepo.findAll();
    }
}
