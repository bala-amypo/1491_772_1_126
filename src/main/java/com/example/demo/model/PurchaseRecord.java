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

    @ManyToOne
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private CustomerProfile customer;

    public PurchaseRecord() {}

    public void setCustomer(CustomerProfile customer) {
        this.customer = customer;
        this.customerId = customer.getId();
    }

    public Double getAmount() { return amount; }
}
