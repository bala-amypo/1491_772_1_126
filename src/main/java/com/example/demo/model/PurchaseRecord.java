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

    // setters REQUIRED by test
    public void setId(Long id) { this.id = id; }
    public void setAmount(Double amount) { this.amount = amount; }
    public void setPurchaseDate(LocalDate purchaseDate) { this.purchaseDate = purchaseDate; }
    public void setStoreLocation(String storeLocation) { this.storeLocation = storeLocation; }

    public void setCustomer(CustomerProfile customer) {
        this.customer = customer;
        this.customerId = customer.getId();
    }

    // getters
    public Long getId() { return id; }
    public Double getAmount() { return amount; }
}
