package com.example.demo.controller;

import com.example.demo.model.TierHistoryRecord;
import com.example.demo.service.TierUpgradeEngineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tier-engine")
public class TierUpgradeEngineController {

    private final TierUpgradeEngineService tierUpgradeEngineService;

    public TierUpgradeEngineController(TierUpgradeEngineService tierUpgradeEngineService) {
        this.tierUpgradeEngineService = tierUpgradeEngineService;
    }

    @PostMapping("/evaluate/{customerId}")
    public TierHistoryRecord evaluateTier(@PathVariable Long customerId) {
        return tierUpgradeEngineService.evaluateAndUpgradeTier(customerId);
    }

    @GetMapping("/history/{customerId}")
    public List<TierHistoryRecord> getHistoryByCustomer(@PathVariable Long customerId) {
        return tierUpgradeEngineService.getHistoryByCustomer(customerId);
    }

    @GetMapping
    public List<TierHistoryRecord> getAllHistory() {
        return tierUpgradeEngineService.getAllHistory();
    }
}
