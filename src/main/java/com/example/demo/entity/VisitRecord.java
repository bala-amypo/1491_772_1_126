// package com.example.demo.entity;

// import jakarta.persistence.*;
// import java.time.LocalDate;
// import java.util.Set;

// @Entity
// @Table(name = "visit_record")
// public class VisitRecord {

//     private static final Set<String> VALID_CHANNELS =
//             Set.of("STORE", "APP", "WEB");

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false)
//     private Long customerId;

//     private LocalDate visitDate;

//     @Column(nullable = false)
//     private String channel;

//     @PrePersist
//     public void validate() {
//         if (!VALID_CHANNELS.contains(channel)) {
//             throw new IllegalArgumentException("Invalid visit channel");
//         }
//         if (visitDate == null) {
//             visitDate = LocalDate.now();
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

//     public LocalDate getVisitDate() {
//         return visitDate;
//     }
    
//     public void setVisitDate(LocalDate visitDate) {
//         this.visitDate = visitDate;
//     }

//     public String getChannel() {
//         return channel;
//     }
    
//     public void setChannel(String channel) {
//         this.channel = channel;
//     }
// }
