package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.CustomerProfile;

public interface CustomerProfileRepo extends JpaRepository<CustomerProfile, Long> {
}
