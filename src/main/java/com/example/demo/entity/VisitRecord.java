package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class VisitRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer visits;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Integer getVisits() { return visits; }
    public void setVisits(Integer visits) { this.visits = visits; }
}
