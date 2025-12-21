package com.example.demo.model;

import java.time.LocalDateTime;

public class TierHistoryRecord {

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
                             String reason,
                             LocalDateTime changedAt) {
        this.customerId = customerId;
        this.oldTier = oldTier;
        this.newTier = newTier;
        this.reason = reason;
        this.changedAt = changedAt;
    }

    // ===== getters =====
    public Long getId() { return id; }
    public Long getCustomerId() { return customerId; }
    public String getOldTier() { return oldTier; }
    public String getNewTier() { return newTier; }
    public String getReason() { return reason; }
    public LocalDateTime getChangedAt() { return changedAt; }

    // ===== setters =====
    public void setId(Long id) { this.id = id; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }
    public void setOldTier(String oldTier) { this.oldTier = oldTier; }
    public void setNewTier(String newTier) { this.newTier = newTier; }
    public void setReason(String reason) { this.reason = reason; }
    public void setChangedAt(LocalDateTime changedAt) { this.changedAt = changedAt; }
}
