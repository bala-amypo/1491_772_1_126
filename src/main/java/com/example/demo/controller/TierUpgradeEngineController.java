package com.example.demo.controller;

import com.example.demo.model.TierHistoryRecord;
import com.example.demo.service.TierUpgradeEngineService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tiers")
public class TierUpgradeEngineController {

    private final TierUpgradeEngineService service;

    public TierUpgradeEngineController(TierUpgradeEngineService service) {
        this.service = service;
    }

    @PostMapping("/evaluate/{customerId}")
    public TierHistoryRecord evaluateAndUpgradeTier(@PathVariable Long customerId) {
        return service.evaluateAndUpgradeTier(customerId);
    }

    @GetMapping("/history/{customerId}")
    public List<TierHistoryRecord> getHistoryByCustomer(@PathVariable Long customerId) {
        return service.getHistoryByCustomer(customerId);
    }

    @GetMapping("/history")
    public List<TierHistoryRecord> getAllHistory() {
        return service.getAllHistory();
    }
}
