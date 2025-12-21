package com.example.demo.controller;

import com.example.demo.model.CustomerProfile;
import com.example.demo.model.TierHistoryRecord;
import com.example.demo.service.TierUpgradeEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tier-engine")
public class TierUpgradeEngineController {

    @Autowired
    private TierUpgradeEngineService service;

    @PostMapping("/evaluate")
    public void evaluateAndUpgrade(@RequestBody CustomerProfile customer) {
        service.evaluateAndUpgradeTier(customer);
    }

    @GetMapping("/history/{customerId}")
    public List<TierHistoryRecord> getHistoryByCustomer(@RequestBody CustomerProfile customer) {
        return service.getHistoryByCustomer(customer);
    }

    @GetMapping("/history")
    public List<TierHistoryRecord> getAllHistory() {
        return service.getAllHistory();
    }
}
