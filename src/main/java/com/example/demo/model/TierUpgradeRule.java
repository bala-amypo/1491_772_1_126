package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tier_upgrade_rules")
public class TierUpgradeRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fromTier;
    private String toTier;
    private Double minSpend;
    private Integer minVisits;
    private Boolean active;

    public TierUpgradeRule() {}

    public TierUpgradeRule(String fromTier, String toTier,
                           Double minSpend, Integer minVisits, Boolean active) {
        this.fromTier = fromTier;
        this.toTier = toTier;
        this.minSpend = minSpend;
        this.minVisits = minVisits;
        this.active = active;
    }

    // getters & setters
    public String getFromTier() { return fromTier; }
    public String getToTier() { return toTier; }
    public Double getMinSpend() { return minSpend; }
    public Integer getMinVisits() { return minVisits; }
    public Boolean getActive() { return active; }
}
