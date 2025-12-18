package com.example.demo.repository;

import com.example.demo.entity.TierUpgradeRule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TierUpgradeRuleRepository extends JpaRepository<TierUpgradeRule, Long> {
    TierUpgradeRule findByFromTierAndToTier(String fromTier, String toTier);
}
