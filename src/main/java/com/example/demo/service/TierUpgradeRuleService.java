package com.example.demo.service;

import com.example.demo.model.TierUpgradeRule;
import java.util.List;

public interface TierUpgradeRuleService {
    TierUpgradeRule createRule(TierUpgradeRule rule);
    TierUpgradeRule getRule(String currentTier, String nextTier);
    List<TierUpgradeRule> getAllRules();
}
