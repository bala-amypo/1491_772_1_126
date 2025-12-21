package com.example.demo.service.impl;

import java.util.*;
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

    public TierUpgradeRule createRule(TierUpgradeRule rule) {
        return repo.save(rule);
    }

    public TierUpgradeRule updateRule(Long id, TierUpgradeRule rule) {
        TierUpgradeRule r = repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Rule not found"));

        r.setFromTier(rule.getFromTier());
        r.setToTier(rule.getToTier());
        r.setMinSpend(rule.getMinSpend());
        r.setMinVisits(rule.getMinVisits());
        r.setActive(rule.getActive());

        return repo.save(r);
    }

    public TierUpgradeRule getRule(String fromTier, String toTier) {
        return repo.findByFromTierAndToTier(fromTier, toTier)
                .orElseThrow(() -> new NoSuchElementException("Rule not found"));
    }

    public List<TierUpgradeRule> getActiveRules() {
        return repo.findByActiveTrue();
    }

    public List<TierUpgradeRule> getAllRules() {
        return repo.findAll();
    }
}
