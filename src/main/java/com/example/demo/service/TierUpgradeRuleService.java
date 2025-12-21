package com.example.demo.service;

import com.example.demo.model.TierUpgradeRule;
import java.util.List;

public interface TierUpgradeRuleService {
    TierUpgradeRule updateRule(Long id, TierUpgradeRule rule);
    List<TierUpgradeRule> getActiveRules();
}
