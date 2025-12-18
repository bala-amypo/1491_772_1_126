package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.CustomerProfile;

public interface CustomerProfileService {

    CustomerProfile createCustomer(CustomerProfile cp);

    List<CustomerProfile> getAllCustomers();
}
