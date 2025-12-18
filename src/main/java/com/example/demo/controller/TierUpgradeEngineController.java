package com.example.demo.controller;

import com.example.demo.entity.CustomerProfile;
import com.example.demo.entity.PurchaseRecord;
import com.example.demo.entity.TierUpgradeRule;
import com.example.demo.service.CustomerProfileService;
import com.example.demo.service.PurchaseRecordService;
import com.example.demo.service.TierUpgradeRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/upgrade")
public class TierUpgradeEngineController {

    @Autowired
    private CustomerProfileService customerService;

    @Autowired
    private PurchaseRecordService purchaseService;

    @Autowired
    private TierUpgradeRuleService ruleService;

    @PostMapping("/{customerId}")
    public String upgradeTier(@PathVariable Long customerId) {
        CustomerProfile customer = customerService.getCustomerById(customerId);
        List<PurchaseRecord> purchases = purchaseService.getPurchasesByCustomer(customerId);
        double totalSpent = purchases.stream().mapToDouble(PurchaseRecord::getAmount).sum();

        List<TierUpgradeRule> rules = ruleService.getAllRules();
        String oldTier = customer.getCurrentTier();

        for (TierUpgradeRule rule : rules) {
            if (rule.getFromTier().equals(oldTier)
                    && totalSpent >= rule.getMinSpend()) {
                customerService.updateTier(customerId, rule.getToTier());
                return "Tier upgraded from " + oldTier + " to " + rule.getToTier();
            }
        }
        return "No tier upgrade available";
    }
}
