package com.example.demo.service;

import com.example.demo.model.TierUpgradeRule;

import java.util.List;
import java.util.Optional;

public interface TierUpgradeRuleService {

    TierUpgradeRule createRule(TierUpgradeRule rule);
    TierUpgradeRule updateRule(Long id, TierUpgradeRule rule);
    void deleteRule(Long id);

    List<TierUpgradeRule> getAllRules();
    List<TierUpgradeRule> getActiveRules();

    Optional<TierUpgradeRule> getRuleByTiers(String currentTier, String nextTier);
}
