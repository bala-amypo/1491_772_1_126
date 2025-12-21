package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.TierUpgradeRule;

public interface TierUpgradeRuleService {

    TierUpgradeRule createRule(TierUpgradeRule rule);

    TierUpgradeRule updateRule(Long id, TierUpgradeRule rule);

    Optional<TierUpgradeRule> getRule(String fromTier, String toTier);

    List<TierUpgradeRule> getActiveRules();

    List<TierUpgradeRule> getAllRules();
}
