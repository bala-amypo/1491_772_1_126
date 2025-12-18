package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class VisitRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private CustomerProfile customer;

    private LocalDate visitDate;

    private String channel;

    public VisitRecord() {}

    public VisitRecord(Long id, CustomerProfile customer, LocalDate visitDate, String channel) {
        this.id = id;
        this.customer = customer;
        this.visitDate = visitDate;
        this.channel = channel;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public CustomerProfile getCustomer() { return customer; }
    public void setCustomer(CustomerProfile customer) { this.customer = customer; }

    public LocalDate getVisitDate() { return visitDate; }
    public void setVisitDate(LocalDate visitDate) { this.visitDate = visitDate; }

    public String getChannel() { return channel; }
    public void setChannel(String channel) { this.channel = channel; }
}
