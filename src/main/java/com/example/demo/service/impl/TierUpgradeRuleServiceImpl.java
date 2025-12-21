package com.example.demo.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.example.demo.model.TierUpgradeRule;
import com.example.demo.repository.TierUpgradeRuleRepository;
import com.example.demo.service.TierUpgradeRuleService;

@Service
public class TierUpgradeRuleServiceImpl implements TierUpgradeRuleService {

    private final TierUpgradeRuleRepository repo;

    public TierUpgradeRuleServiceImpl(TierUpgradeRuleRepository repo) {
        this.repo = repo;
    }

    @Override
    public TierUpgradeRule createRule(TierUpgradeRule rule) {
        return repo.save(rule);
    }

    @Override
    public TierUpgradeRule updateRule(Long id, TierUpgradeRule rule) {
        TierUpgradeRule existing = repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Rule not found"));

        existing.setFromTier(rule.getFromTier());
        existing.setToTier(rule.getToTier());
        existing.setMinSpend(rule.getMinSpend());
        existing.setMinVisits(rule.getMinVisits());
        existing.setActive(rule.getActive());

        return repo.save(existing);
    }

    @Override
    public TierUpgradeRule getRule(String fromTier, String toTier) {
        return repo.findByFromTierAndToTier(fromTier, toTier)
                .orElseThrow(() -> new NoSuchElementException("Rule not found"));
    }

    @Override
    public List<TierUpgradeRule> getActiveRules() {
        return repo.findByActiveTrue();
    }

    @Override
    public List<TierUpgradeRule> getAllRules() {
        return repo.findAll();
    }
}
