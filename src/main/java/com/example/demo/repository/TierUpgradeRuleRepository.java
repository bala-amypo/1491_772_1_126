package com.example.demo.repository;

import com.example.demo.model.TierUpgradeRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TierUpgradeRuleRepository extends JpaRepository<TierUpgradeRule, Long> {

    List<TierUpgradeRule> findByActive(boolean active);

    Optional<TierUpgradeRule> findByCurrentTierAndNextTier(String currentTier, String nextTier);
}
