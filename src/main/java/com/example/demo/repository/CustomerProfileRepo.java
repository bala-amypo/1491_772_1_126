package com.example.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.CustomerProfile;

@Repository
public interface CustomerProfileRepo extends JpaRepository<CustomerProfile, Long> {
    Optional<CustomerProfile> findByEmail(String email);
    Optional<CustomerProfile> findByCustomerId(String customerId);
}
