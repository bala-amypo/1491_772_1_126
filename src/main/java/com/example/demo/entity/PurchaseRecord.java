// package com.example.demo.entity;

// import jakarta.persistence.*;
// import java.time.LocalDate;

// @Entity
// @Table(name = "purchase_record")
// public class PurchaseRecord {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false)
//     private Long customerId;

//     @Column(nullable = false)
//     private Double amount;

//     private LocalDate purchaseDate;

//     private String storeLocation;

//     @PrePersist
//     public void validate() {
//         if (amount == null || amount <= 0) {
//             throw new IllegalArgumentException("Purchase amount must be greater than zero");
//         }
//         if (purchaseDate == null) {
//             purchaseDate = LocalDate.now();
//         }
//     }

//     // Getters and Setters

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public Long getCustomerId() {
//         return customerId;
//     }
    
//     public void setCustomerId(Long customerId) {
//         this.customerId = customerId;
//     }

//     public Double getAmount() {
//         return amount;
//     }
    
//     public void setAmount(Double amount) {
//         this.amount = amount;
//     }

//     public LocalDate getPurchaseDate() {
//         return purchaseDate;
//     }
    
//     public void setPurchaseDate(LocalDate purchaseDate) {
//         this.purchaseDate = purchaseDate;
//     }

//     public String getStoreLocation() {
//         return storeLocation;
//     }
    
//     public void setStoreLocation(String storeLocation) {
//         this.storeLocation = storeLocation;
//     }
// }
