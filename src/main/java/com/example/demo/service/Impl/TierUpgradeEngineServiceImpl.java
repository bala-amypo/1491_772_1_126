package com.example.demo.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.example.demo.entity.CustomerProfile;
import com.example.demo.entity.TierHistoryRecord;
import com.example.demo.entity.TierUpgradeRule;
import com.example.demo.repository.CustomerProfileRepository;
import com.example.demo.repository.PurchaseRecordRepository;
import com.example.demo.repository.TierHistoryRecordRepository;
import com.example.demo.repository.TierUpgradeRuleRepository;
import com.example.demo.repository.VisitRecordRepository;
import com.example.demo.service.TierUpgradeEngineService;

@Service
public class TierUpgradeEngineServiceImpl
        implements TierUpgradeEngineService {

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
                .orElseThrow(() ->
                        new NoSuchElementException("Customer not found"));

        double totalSpend =
                purchaseRepo.findByCustomerId(customerId)
                        .stream()
                        .mapToDouble(p -> p.getAmount())
                        .sum();

        int totalVisits =
                visitRepo.findByCustomerId(customerId).size();

        String currentTier = customer.getCurrentTier();

        List<TierUpgradeRule> rules =
                ruleRepo.findByActiveTrue()
                        .stream()
                        .filter(r -> r.getFromTier().equals(currentTier))
                        .toList();

        for (TierUpgradeRule rule : rules) {

            if (totalSpend >= rule.getMinSpend()
                    && totalVisits >= rule.getMinVisits()) {

                String oldTier = customer.getCurrentTier();
                String newTier = rule.getToTier();

                customer.setCurrentTier(newTier);
                customerRepo.save(customer);

                TierHistoryRecord history =
                        new TierHistoryRecord(
                                customerId,
                                oldTier,
                                newTier,
                                "Auto tier upgrade",
                                null
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
