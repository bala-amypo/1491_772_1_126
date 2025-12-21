package com.example.demo.model;

import java.time.LocalDateTime;

public class CustomerProfile {

    private Long id;
    private String customerId;
    private String fullName;
    private String email;
    private String phone;
    private String currentTier;
    private boolean active;
    private LocalDateTime createdAt;

    public CustomerProfile() {}

    // ===== getters =====
    public Long getId() { return id; }
    public String getCustomerId() { return customerId; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getCurrentTier() { return currentTier; }
    public boolean isActive() { return active; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    // ===== setters (REQUIRED BY TEST) =====
    public void setId(Long id) { this.id = id; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setCurrentTier(String currentTier) { this.currentTier = currentTier; }
    public void setActive(boolean active) { this.active = active; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
