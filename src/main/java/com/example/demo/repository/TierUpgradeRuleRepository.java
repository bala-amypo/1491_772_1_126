package com.example.demo.repository;

import com.example.demo.model.TierUpgradeRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface TierUpgradeRuleRepository extends JpaRepository<TierUpgradeRule, Long> {
    Optional<TierUpgradeRule> findByCurrentTierAndNextTier(String currentTier, String nextTier);
    List<TierUpgradeRule> findByActiveTrue();
}
