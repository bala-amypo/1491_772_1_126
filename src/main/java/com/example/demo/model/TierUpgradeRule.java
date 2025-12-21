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

    private int pointsRequired;
    private int visitsRequired;

    private boolean active;

    public TierUpgradeRule() {}

    public TierUpgradeRule(String currentTier, String nextTier, int pointsRequired, int visitsRequired, boolean active) {
        this.currentTier = currentTier;
        this.nextTier = nextTier;
        this.pointsRequired = pointsRequired;
        this.visitsRequired = visitsRequired;
        this.active = active;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCurrentTier() { return currentTier; }
    public void setCurrentTier(String currentTier) { this.currentTier = currentTier; }

    public String getNextTier() { return nextTier; }
    public void setNextTier(String nextTier) { this.nextTier = nextTier; }

    public int getPointsRequired() { return pointsRequired; }
    public void setPointsRequired(int pointsRequired) { this.pointsRequired = pointsRequired; }

    public int getVisitsRequired() { return visitsRequired; }
    public void setVisitsRequired(int visitsRequired) { this.visitsRequired = visitsRequired; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
