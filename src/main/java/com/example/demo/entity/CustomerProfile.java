package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class CustomerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String tier;

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getTier() { return tier; }
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setTier(String tier) { this.tier = tier; }
}
