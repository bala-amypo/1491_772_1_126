package com.example.demo.model;

import java.time.LocalDate;

public class PurchaseRecord {

    private Long id;
    private Long customerId;
    private Double amount;
    private LocalDate purchaseDate;
    private String storeLocation;

    public PurchaseRecord() {}

    // ===== setters (USED BY TEST) =====
    public void setId(Long id) { this.id = id; }
    public void setAmount(Double amount) { this.amount = amount; }
    public void setPurchaseDate(LocalDate purchaseDate) { this.purchaseDate = purchaseDate; }
    public void setStoreLocation(String storeLocation) { this.storeLocation = storeLocation; }

    public void setCustomer(CustomerProfile customer) {
        this.customerId = customer.getId();
    }

    // ===== getters =====
    public Long getId() { return id; }
    public Long getCustomerId() { return customerId; }
    public Double getAmount() { return amount; }
    public LocalDate getPurchaseDate() { return purchaseDate; }
    public String getStoreLocation() { return storeLocation; }
}
