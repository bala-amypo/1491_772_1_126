package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

import java.time.LocalDate;

@Entity
@Table(name = "visit_record")
public class VisitRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id")
    private Long customerId;

    private LocalDate visitDate;
    private String channel;

    // ✅ required by JPA
    public VisitRecord() {}

    // ===== setters (USED BY TEST) =====
    public void setId(Long id) { this.id = id; }
    public void setVisitDate(LocalDate visitDate) { this.visitDate = visitDate; }
    public void setChannel(String channel) { this.channel = channel; }

    // keeps test logic intact
    public void setCustomer(CustomerProfile customer) {
        this.customerId = customer.getId();
    }

    // ===== getters =====
    public Long getId() { return id; }
    public Long getCustomerId() { return customerId; }
    public LocalDate getVisitDate() { return visitDate; }
    public String getChannel() { return channel; }
}
