package com.example.demo.model;

public class TierUpgradeRule {

    private Long id;
    private String fromTier;
    private String toTier;
    private Double minSpend;
    private Integer minVisits;
    private Boolean active;

    public TierUpgradeRule() {}

    // ===== setters (USED BY TEST) =====
    public void setId(Long id) { this.id = id; }
    public void setFromTier(String fromTier) { this.fromTier = fromTier; }
    public void setToTier(String toTier) { this.toTier = toTier; }
    public void setMinSpend(Double minSpend) { this.minSpend = minSpend; }
    public void setMinVisits(Integer minVisits) { this.minVisits = minVisits; }
    public void setActive(Boolean active) { this.active = active; }

    // ===== getters =====
    public Long getId() { return id; }
    public String getFromTier() { return fromTier; }
    public String getToTier() { return toTier; }
    public Double getMinSpend() { return minSpend; }
    public Integer getMinVisits() { return minVisits; }
    public Boolean getActive() { return active; }
}
