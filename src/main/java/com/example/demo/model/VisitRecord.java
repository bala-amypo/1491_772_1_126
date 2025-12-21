package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "visit_records")
public class VisitRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime visitDate = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerProfile customer;

    // No-arg constructor
    public VisitRecord() {}

    // All-args constructor
    public VisitRecord(Long id, LocalDateTime visitDate, CustomerProfile customer) {
        this.id = id;
        this.visitDate = visitDate;
        this.customer = customer;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getVisitDate() { return visitDate; }
    public void setVisitDate(LocalDateTime visitDate) { this.visitDate = visitDate; }

    public CustomerProfile getCustomer() { return customer; }
    public void setCustomer(CustomerProfile customer) { this.customer = customer; }
}
