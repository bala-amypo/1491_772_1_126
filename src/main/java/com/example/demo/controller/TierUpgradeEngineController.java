package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.TierHistoryRecord;
import com.example.demo.service.TierUpgradeEngineService;

@RestController
@RequestMapping("/tier-engine")
public class TierUpgradeEngineController {

    private final TierUpgradeEngineService engineService;

    public TierUpgradeEngineController(
            TierUpgradeEngineService engineService) {
        this.engineService = engineService;
    }

    // Evaluate and upgrade tier
    @PostMapping("/evaluate/{customerId}")
    public TierHistoryRecord evaluateTier(
            @PathVariable Long customerId) {
        return engineService.evaluateAndUpgradeTier(customerId);
    }

    // Get history by customer
    @GetMapping("/history/{customerId}")
    public List<TierHistoryRecord> getHistoryByCustomer(
            @PathVariable Long customerId) {
        return engineService.getHistoryByCustomer(customerId);
    }

    // Get all history
    @GetMapping
    public List<TierHistoryRecord> getAllHistory() {
        return engineService.getAllHistory();
    }
}
