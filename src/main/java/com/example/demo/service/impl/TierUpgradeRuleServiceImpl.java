package com.example.demo.service.impl;

import com.example.demo.model.TierUpgradeRule;
import com.example.demo.repository.TierUpgradeRuleRepository;
import com.example.demo.service.TierUpgradeRuleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TierUpgradeRuleServiceImpl implements TierUpgradeRuleService {

    private final TierUpgradeRuleRepository repository;

    public TierUpgradeRuleServiceImpl(TierUpgradeRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public TierUpgradeRule createRule(TierUpgradeRule rule) {
        return repository.save(rule);
    }

    @Override
    public TierUpgradeRule updateRule(Long id, TierUpgradeRule rule) {
        TierUpgradeRule updatedRule = repository.findById(id).orElseThrow(() -> new RuntimeException("Rule not found"));
        updatedRule.setCurrentTier(rule.getCurrentTier());
        updatedRule.setNextTier(rule.getNextTier());
        updatedRule.setPointsRequired(rule.getPointsRequired());
        updatedRule.setVisitsRequired(rule.getVisitsRequired());
        updatedRule.setActive(rule.getActive());
        return repository.save(updatedRule);
    }

    @Override
    public List<TierUpgradeRule> getActiveRules() {
        return repository.findByActive(true);
    }

    @Override
    public Optional<TierUpgradeRule> getRule(String currentTier, String nextTier) {
        return repository.findByCurrentTierAndNextTier(currentTier, nextTier);
    }
}
