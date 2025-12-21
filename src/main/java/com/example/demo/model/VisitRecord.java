package com.example.demo.model;

import java.time.LocalDate;

public class VisitRecord {

    private Long id;
    private Long customerId;
    private LocalDate visitDate;
    private String channel;

    public VisitRecord() {}

    // ===== setters (USED BY TEST) =====
    public void setId(Long id) { this.id = id; }
    public void setVisitDate(LocalDate visitDate) { this.visitDate = visitDate; }
    public void setChannel(String channel) { this.channel = channel; }

    public void setCustomer(CustomerProfile customer) {
        this.customerId = customer.getId();
    }

    // ===== getters =====
    public Long getId() { return id; }
    public Long getCustomerId() { return customerId; }
    public LocalDate getVisitDate() { return visitDate; }
    public String getChannel() { return channel; }
}
