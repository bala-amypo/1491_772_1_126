package com.example.demo.service;

import com.example.demo.entity.TierUpgradeRule;
import com.example.demo.repository.TierUpgradeRuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TierUpgradeRuleService {

    @Autowired
    private TierUpgradeRuleRepository repository;

    public void createRule(TierUpgradeRule rule) {
        repository.save(rule);
    }

    public void updateRule(Long id, TierUpgradeRule updatedRule) {
        repository.findById(id).ifPresent(existing -> {
            existing.setFromTier(updatedRule.getFromTier());
            existing.setToTier(updatedRule.getToTier());
            existing.setMinSpend(updatedRule.getMinSpend());
            existing.setMinVisits(updatedRule.getMinVisits());
            existing.setActive(updatedRule.getActive());
            repository.save(existing);
        });
    }

    public List<TierUpgradeRule> getActiveRules() {
        return repository.findAll(); // Filter by active = true if needed
    }

    public List<TierUpgradeRule> getAllRules() {
        return repository.findAll();
    }

    public TierUpgradeRule getRule(String fromTier, String toTier) {
        return repository.findByFromTierAndToTier(fromTier, toTier);
    }
}
