package com.example.demo.repository;

import com.example.demo.model.TierUpgradeRule;

import java.util.List;
import java.util.Optional;

public interface TierUpgradeRuleRepository {

    TierUpgradeRule save(TierUpgradeRule rule);

    Optional<TierUpgradeRule> findById(Long id);

    List<TierUpgradeRule> findAll();

    Optional<TierUpgradeRule> findByFromTierAndToTier(String fromTier, String toTier);

    List<TierUpgradeRule> findByActiveTrue();
}
