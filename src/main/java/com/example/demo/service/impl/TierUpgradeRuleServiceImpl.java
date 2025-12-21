package com.example.demo.service.impl;

import com.example.demo.model.TierUpgradeRule;
import com.example.demo.repository.TierUpgradeRuleRepository;
import com.example.demo.service.TierUpgradeRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TierUpgradeRuleServiceImpl implements TierUpgradeRuleService {

    @Autowired
    private TierUpgradeRuleRepository repository;

    @Override
    public TierUpgradeRule createRule(TierUpgradeRule rule) {
        return repository.save(rule);
    }

    @Override
    public TierUpgradeRule updateRule(Long id, TierUpgradeRule updatedRule) {
        TierUpgradeRule rule = repository.findById(id).orElseThrow();
        rule.setCurrentTier(updatedRule.getCurrentTier());
        rule.setNextTier(updatedRule.getNextTier());
        rule.setPointsRequired(updatedRule.getPointsRequired());
        rule.setVisitsRequired(updatedRule.getVisitsRequired());
        rule.setActive(updatedRule.isActive());
        return repository.save(rule);
    }

    @Override
    public List<TierUpgradeRule> getAllRules() {
        return repository.findAll();
    }

    @Override
    public List<TierUpgradeRule> getActiveRules() {
        return repository.findByActive(true);
    }

    @Override
    public Optional<TierUpgradeRule> getRule(String currentTier, String nextTier) {
        return repository.findByCurrentTierAndNextTier(currentTier, nextTier);
    }

    @Override
    public void deleteRule(Long id) {
        repository.deleteById(id);
    }
}
