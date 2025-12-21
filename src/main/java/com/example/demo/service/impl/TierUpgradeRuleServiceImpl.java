package com.example.demo.service.impl;

import com.example.demo.model.TierUpgradeRule;
import com.example.demo.repository.TierUpgradeRuleRepository;
import com.example.demo.service.TierUpgradeRuleService;

import java.util.List;
import java.util.NoSuchElementException;

public class TierUpgradeRuleServiceImpl implements TierUpgradeRuleService {

    private final TierUpgradeRuleRepository tierUpgradeRuleRepository;

    public TierUpgradeRuleServiceImpl(TierUpgradeRuleRepository tierUpgradeRuleRepository) {
        this.tierUpgradeRuleRepository = tierUpgradeRuleRepository;
    }

    @Override
    public TierUpgradeRule createRule(TierUpgradeRule rule) {
        if (rule.getMinSpend() < 0) throw new IllegalArgumentException("minSpend must be >= 0");
        if (rule.getMinVisits() < 0) throw new IllegalArgumentException("minVisits must be >= 0");
        return tierUpgradeRuleRepository.save(rule);
    }

    @Override
    public TierUpgradeRule updateRule(Long id, TierUpgradeRule updatedRule) {
        TierUpgradeRule existingRule = tierUpgradeRuleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Rule not found"));

        existingRule.setFromTier(updatedRule.getFromTier());
        existingRule.setToTier(updatedRule.getToTier());
        existingRule.setMinSpend(updatedRule.getMinSpend());
        existingRule.setMinVisits(updatedRule.getMinVisits());
        existingRule.setActive(updatedRule.getActive());

        return tierUpgradeRuleRepository.save(existingRule);
    }

    @Override
    public List<TierUpgradeRule> getActiveRules() {
        return tierUpgradeRuleRepository.findByActiveTrue();
    }

    @Override
    public TierUpgradeRule getRule(String fromTier, String toTier) {
        return tierUpgradeRuleRepository.findByFromTierAndToTier(fromTier, toTier)
                .orElseThrow(() -> new NoSuchElementException("Rule not found"));
    }

    @Override
    public List<TierUpgradeRule> getAllRules() {
        return tierUpgradeRuleRepository.findAll();
    }
}
