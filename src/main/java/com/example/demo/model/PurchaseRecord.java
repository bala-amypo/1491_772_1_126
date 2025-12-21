package com.example.demo.model;

import java.time.LocalDate;

public class PurchaseRecord {

    private Long id;
    private CustomerProfile customer;
    private double amount;
    private LocalDate purchaseDate;
    private String storeLocation;

    public PurchaseRecord() {}

    public PurchaseRecord(CustomerProfile customer, double amount, LocalDate purchaseDate, String storeLocation) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        if (customer == null) throw new IllegalArgumentException("Customer cannot be null");

        this.customer = customer;
        this.amount = amount;
        this.purchaseDate = purchaseDate;
        this.storeLocation = storeLocation;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public CustomerProfile getCustomer() { return customer; }
    public void setCustomer(CustomerProfile customer) { this.customer = customer; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        this.amount = amount;
    }

    public LocalDate getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(LocalDate purchaseDate) { this.purchaseDate = purchaseDate; }

    public String getStoreLocation() { return storeLocation; }
    public void setStoreLocation(String storeLocation) { this.storeLocation = storeLocation; }
}
