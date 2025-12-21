package com.example.demo.controller;

import com.example.demo.model.TierHistoryRecord;
import com.example.demo.service.TierUpgradeEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/engine")
public class TierUpgradeEngineController {

    @Autowired
    private TierUpgradeEngineService service;

    @PostMapping("/evaluate/{customerId}")
    public void evaluateCustomer(@PathVariable Long customerId) {
        service.evaluateAndUpgradeTier(customerId);
    }

    @GetMapping("/history/{customerId}")
    public List<TierHistoryRecord> getCustomerHistory(@PathVariable Long customerId) {
        return service.getHistoryByCustomer(customerId);
    }

    @GetMapping("/history")
    public List<TierHistoryRecord> getAllHistory() {
        return service.getAllHistory();
    }
}
