package com.example.demo.controller;

import com.example.demo.service.TierUpgradeEngineService;
import com.example.demo.entity.TierHistoryRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tier-engine")
public class TierUpgradeEngineController {

    private final TierUpgradeEngineService tierUpgradeEngineService;

    @Autowired
    public TierUpgradeEngineController(TierUpgradeEngineService tierUpgradeEngineService) {
        this.tierUpgradeEngineService = tierUpgradeEngineService;
    }

    @PostMapping("/evaluate/{customerId}")
    public void evaluateAndUpgradeTier(@PathVariable Long customerId) {
        tierUpgradeEngineService.evaluateAndUpgradeTier(customerId);
    }

    @GetMapping("/history/{customerId}")
    public Iterable<TierHistoryRecord> getTierHistoryByCustomer(@PathVariable Long customerId) {
        return tierUpgradeEngineService.getHistoryByCustomer(customerId);
    }

    @GetMapping("/history/{id}")
    public TierHistoryRecord getTierHistoryById(@PathVariable Long id) {
        return tierUpgradeEngineService.getTierHistoryById(id);
    }

    @GetMapping("/history")
    public Iterable<TierHistoryRecord> getAllHistory() {
        return tierUpgradeEngineService.getAllHistory();
    }
}
