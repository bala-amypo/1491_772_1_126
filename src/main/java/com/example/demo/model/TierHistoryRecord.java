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
    private CustomerProfile customer;

    private String oldTier;
    private String newTier;
    private String action; // UPGRADE, DOWNGRADE
    private LocalDateTime createdAt;

    public TierHistoryRecord() { }

    // Constructor used in TierUpgradeEngineService
    public TierHistoryRecord(CustomerProfile customer, String oldTier, String newTier, String action) {
        this.customer = customer;
        this.oldTier = oldTier;
        this.newTier = newTier;
        this.action = action;
        this.createdAt = LocalDateTime.now();
    }

    // Full constructor
    public TierHistoryRecord(Long id, CustomerProfile customer, String oldTier, String newTier, String action, LocalDateTime createdAt) {
        this.id = id;
        this.customer = customer;
        this.oldTier = oldTier;
        this.newTier = newTier;
        this.action = action;
        this.createdAt = createdAt;
    }

    // Getters and Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public CustomerProfile getCustomer() { return customer; }
    public void setCustomer(CustomerProfile customer) { this.customer = customer; }

    public String getOldTier() { return oldTier; }
    public void setOldTier(String oldTier) { this.oldTier = oldTier; }

    public String getNewTier() { return newTier; }
    public void setNewTier(String newTier) { this.newTier = newTier; }

    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
