package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tier_history_records")
public class TierHistoryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerProfile customer;

    private String previousTier;

    private String upgradedTier;

    private String reason;

    private LocalDateTime createdAt = LocalDateTime.now();

    // No-arg constructor
    public TierHistoryRecord() {}

    // All-args constructor
    public TierHistoryRecord(Long id, CustomerProfile customer, String previousTier, String upgradedTier, String reason, LocalDateTime createdAt) {
        this.id = id;
        this.customer = customer;
        this.previousTier = previousTier;
        this.upgradedTier = upgradedTier;
        this.reason = reason;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public CustomerProfile getCustomer() { return customer; }
    public void setCustomer(CustomerProfile customer) { this.customer = customer; }

    public String getPreviousTier() { return previousTier; }
    public void setPreviousTier(String previousTier) { this.previousTier = previousTier; }

    public String getUpgradedTier() { return upgradedTier; }
    public void setUpgradedTier(String upgradedTier) { this.upgradedTier = upgradedTier; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
