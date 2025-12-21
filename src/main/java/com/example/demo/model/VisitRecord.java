package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "visit_records")
public class VisitRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;
    private LocalDate visitDate;
    private String channel;

    @ManyToOne
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private CustomerProfile customer;

    public VisitRecord() {}

    public VisitRecord(Long customerId, LocalDate visitDate, String channel) {
        this.customerId = customerId;
        this.visitDate = visitDate;
        this.channel = channel;
    }

    public void setCustomer(CustomerProfile customer) {
        this.customer = customer;
        this.customerId = customer.getId();
    }

    public CustomerProfile getCustomer() { return customer; }

    // getters
    public Long getId() { return id; }
    public String getChannel() { return channel; }
}
