package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "purchase_records")
public class PurchaseRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    private LocalDateTime purchaseDate = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerProfile customer;

    // No-arg constructor
    public PurchaseRecord() {}

    // All-args constructor
    public PurchaseRecord(Long id, Double amount, LocalDateTime purchaseDate, CustomerProfile customer) {
        this.id = id;
        this.amount = amount;
        this.purchaseDate = purchaseDate;
        this.customer = customer;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public LocalDateTime getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(LocalDateTime purchaseDate) { this.purchaseDate = purchaseDate; }

    public CustomerProfile getCustomer() { return customer; }
    public void setCustomer(CustomerProfile customer) { this.customer = customer; }
}
