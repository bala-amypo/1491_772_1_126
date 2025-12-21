package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tier_history_records")
public class TierHistoryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;
    private String oldTier;
    private String newTier;
    private String reason;
    private LocalDateTime changedAt;

    public TierHistoryRecord() {}

    public TierHistoryRecord(Long customerId,
                             String oldTier,
                             String newTier,
                             String reason) {
        this.customerId = customerId;
        this.oldTier = oldTier;
        this.newTier = newTier;
        this.reason = reason;
    }

    @PrePersist
    public void onCreate() {
        this.changedAt = LocalDateTime.now();
    }

    // getters
    public Long getId() { return id; }
    public Long getCustomerId() { return customerId; }
    public String getOldTier() { return oldTier; }
    public String getNewTier() { return newTier; }
    public String getReason() { return reason; }
    public LocalDateTime getChangedAt() { return changedAt; }
}
