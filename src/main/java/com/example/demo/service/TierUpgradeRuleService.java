package com.example.demo.service;

import java.util.List;
import com.example.demo.model.TierUpgradeRule;

public interface TierUpgradeRuleService {
    TierUpgradeRule createRule(TierUpgradeRule rule);
    TierUpgradeRule updateRule(Long id, TierUpgradeRule rule);
    TierUpgradeRule getRule(String fromTier, String toTier);
    List<TierUpgradeRule> getActiveRules();
    List<TierUpgradeRule> getAllRules();
}
