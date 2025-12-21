package com.example.demo.model;

public class TierUpgradeRule {

    private Long id;
    private String fromTier;
    private String toTier;
    private double minSpend;
    private int minVisits;
    private boolean active;

    public TierUpgradeRule() { this.active = true; }

    public TierUpgradeRule(String fromTier, String toTier, double minSpend, int minVisits, boolean active) {
        if (minSpend < 0 || minVisits < 0) throw new IllegalArgumentException("minSpend and minVisits must be >= 0");
        this.fromTier = fromTier;
        this.toTier = toTier;
        this.minSpend = minSpend;
        this.minVisits = minVisits;
        this.active = active;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFromTier() { return fromTier; }
    public void setFromTier(String fromTier) { this.fromTier = fromTier; }

    public String getToTier() { return toTier; }
    public void setToTier(String toTier) { this.toTier = toTier; }

    public double getMinSpend() { return minSpend; }
    public void setMinSpend(double minSpend) {
        if (minSpend < 0) throw new IllegalArgumentException("minSpend must be >= 0");
        this.minSpend = minSpend;
    }

    public int getMinVisits() { return minVisits; }
    public void setMinVisits(int minVisits) {
        if (minVisits < 0) throw new IllegalArgumentException("minVisits must be >= 0");
        this.minVisits = minVisits;
    }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
