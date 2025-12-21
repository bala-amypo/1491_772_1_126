package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.TierUpgradeEngineService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

public class TierUpgradeEngineServiceImpl implements TierUpgradeEngineService {

    private final CustomerProfileRepository customerProfileRepository;
    private final PurchaseRecordRepository purchaseRecordRepository;
    private final VisitRecordRepository visitRecordRepository;
    private final TierUpgradeRuleRepository tierUpgradeRuleRepository;
    private final TierHistoryRecordRepository tierHistoryRecordRepository;

    public TierUpgradeEngineServiceImpl(
            CustomerProfileRepository customerProfileRepository,
            PurchaseRecordRepository purchaseRecordRepository,
            VisitRecordRepository visitRecordRepository,
            TierUpgradeRuleRepository tierUpgradeRuleRepository,
            TierHistoryRecordRepository tierHistoryRecordRepository
    ) {
        this.customerProfileRepository = customerProfileRepository;
        this.purchaseRecordRepository = purchaseRecordRepository;
        this.visitRecordRepository = visitRecordRepository;
        this.tierUpgradeRuleRepository = tierUpgradeRuleRepository;
        this.tierHistoryRecordRepository = tierHistoryRecordRepository;
    }

    @Override
    public TierHistoryRecord evaluateAndUpgradeTier(Long customerId) {
        CustomerProfile customer = customerProfileRepository.findById(customerId)
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));

        double totalSpend = purchaseRecordRepository.findByCustomerId(customerId)
                .stream().mapToDouble(PurchaseRecord::getAmount).sum();

        int totalVisits = visitRecordRepository.findByCustomerId(customerId).size();

        String currentTier = customer.getCurrentTier();

        List<TierUpgradeRule> rules = tierUpgradeRuleRepository.findByActiveTrue()
                .stream().filter(r -> r.getFromTier().equals(currentTier)).toList();

        for (TierUpgradeRule rule : rules) {
            if (totalSpend >= rule.getMinSpend() && totalVisits >= rule.getMinVisits()) {
                String oldTier = customer.getCurrentTier();
                String newTier = rule.getToTier();
                customer.setCurrentTier(newTier);
                customerProfileRepository.save(customer);

                TierHistoryRecord history = new TierHistoryRecord(customer, oldTier, newTier,
                        "Upgrade via engine");
                tierHistoryRecordRepository.save(history);
                return history;
            }
        }
        return null;
    }

    @Override
    public List<TierHistoryRecord> getHistoryByCustomer(Long customerId) {
        return tierHistoryRecordRepository.findByCustomerId(customerId);
    }

    @Override
    public List<TierHistoryRecord> getAllHistory() {
        return tierHistoryRecordRepository.findAll();
    }
}
