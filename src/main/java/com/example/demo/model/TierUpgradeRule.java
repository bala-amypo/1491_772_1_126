package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tier_upgrade_rules")
public class TierUpgradeRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String currentTier;

    private String nextTier;

    private Double minPurchaseAmount;

    private Boolean active = true;

    // No-arg constructor
    public TierUpgradeRule() {}

    // All-args constructor
    public TierUpgradeRule(Long id, String currentTier, String nextTier, Double minPurchaseAmount, Boolean active) {
        this.id = id;
        this.currentTier = currentTier;
        this.nextTier = nextTier;
        this.minPurchaseAmount = minPurchaseAmount;
        this.active = active;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCurrentTier() { return currentTier; }
    public void setCurrentTier(String currentTier) { this.currentTier = currentTier; }

    public String getNextTier() { return nextTier; }
    public void setNextTier(String nextTier) { this.nextTier = nextTier; }

    public Double getMinPurchaseAmount() { return minPurchaseAmount; }
    public void setMinPurchaseAmount(Double minPurchaseAmount) { this.minPurchaseAmount = minPurchaseAmount; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
