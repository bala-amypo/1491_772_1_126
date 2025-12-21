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

    public VisitRecord() {}

    // setters REQUIRED by test
    public void setId(Long id) { this.id = id; }
    public void setChannel(String channel) { this.channel = channel; }
    public void setVisitDate(LocalDate visitDate) { this.visitDate = visitDate; }

    // getters
    public String getChannel() { return channel; }
}
