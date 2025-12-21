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
    public TierUpgradeRule updateRule(Long id, TierUpgradeRule rule) {
        TierUpgradeRule existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rule not found"));
        existing.setCurrentTier(rule.getCurrentTier());
        existing.setNextTier(rule.getNextTier());
        existing.setPointsRequired(rule.getPointsRequired());
        existing.setVisitsRequired(rule.getVisitsRequired());
        existing.setActive(rule.isActive());
        return repository.save(existing);
    }

    @Override
    public void deleteRule(Long id) {
        repository.deleteById(id);
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
    public Optional<TierUpgradeRule> getRuleByTiers(String currentTier, String nextTier) {
        return repository.findByCurrentTierAndNextTier(currentTier, nextTier);
    }
}
