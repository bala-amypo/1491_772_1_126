package com.example.demo.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.TierUpgradeEngineService;

@Service
public class TierUpgradeEngineServiceImpl implements TierUpgradeEngineService {

    private final CustomerProfileRepository customerRepo;
    private final PurchaseRecordRepository purchaseRepo;
    private final VisitRecordRepository visitRepo;
    private final TierUpgradeRuleRepository ruleRepo;
    private final TierHistoryRecordRepository historyRepo;

    public TierUpgradeEngineServiceImpl(
            CustomerProfileRepository customerRepo,
            PurchaseRecordRepository purchaseRepo,
            VisitRecordRepository visitRepo,
            TierUpgradeRuleRepository ruleRepo,
            TierHistoryRecordRepository historyRepo) {

        this.customerRepo = customerRepo;
        this.purchaseRepo = purchaseRepo;
        this.visitRepo = visitRepo;
        this.ruleRepo = ruleRepo;
        this.historyRepo = historyRepo;
    }

    @Override
    public TierHistoryRecord evaluateAndUpgradeTier(Long customerId) {

        CustomerProfile customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));

        double totalSpend = purchaseRepo.findByCustomerId(customerId)
                .stream()
                .mapToDouble(PurchaseRecord::getAmount)
                .sum();

        int totalVisits = visitRepo.findByCustomerId(customerId).size();

        String currentTier = customer.getCurrentTier();

        for (TierUpgradeRule rule : ruleRepo.findByActiveTrue()) {
            if (rule.getFromTier().equals(currentTier)
                    && totalSpend >= rule.getMinSpend()
                    && totalVisits >= rule.getMinVisits()) {

                customer.setCurrentTier(rule.getToTier());
                customerRepo.save(customer);

                TierHistoryRecord history = new TierHistoryRecord(
                        customerId,
                        rule.getFromTier(),
                        rule.getToTier(),
                        "Auto upgrade based on rules"
                );

                return historyRepo.save(history);
            }
        }
        return null;
    }

    @Override
    public List<TierHistoryRecord> getHistoryByCustomer(Long customerId) {
        return historyRepo.findByCustomerId(customerId);
    }

    @Override
    public List<TierHistoryRecord> getAllHistory() {
        return historyRepo.findAll();
    }
}
