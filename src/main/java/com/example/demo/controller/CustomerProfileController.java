package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "customer_profiles")
public class CustomerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String customerId;

    private String fullName;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String phone;

    private String currentTier;
    private Boolean active;
    private LocalDateTime createdAt;

    public CustomerProfile() {}

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        if (currentTier == null) currentTier = "BRONZE";
        if (active == null) active = true;
    }

    // Getters & Setters
    public Long getId() { return id; }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getCurrentTier() { return currentTier; }
    public void setCurrentTier(String currentTier) { this.currentTier = currentTier; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public boolean isActive() {
        return Boolean.TRUE.equals(active);
    }
}
