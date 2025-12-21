package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "purchase_records")
public class PurchaseRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;
    private Double amount;
    private LocalDate purchaseDate;
    private String storeLocation;

    @ManyToOne
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private CustomerProfile customer;

    public PurchaseRecord() {}

    public PurchaseRecord(Long customerId, Double amount,
                          LocalDate purchaseDate, String storeLocation) {
        this.customerId = customerId;
        this.amount = amount;
        this.purchaseDate = purchaseDate;
        this.storeLocation = storeLocation;
    }

    public void setCustomer(CustomerProfile customer) {
        this.customer = customer;
        this.customerId = customer.getId();
    }

    public CustomerProfile getCustomer() { return customer; }

    // getters & setters
    public Long getId() { return id; }
    public Long getCustomerId() { return customerId; }
    public Double getAmount() { return amount; }
    public LocalDate getPurchaseDate() { return purchaseDate; }
}
