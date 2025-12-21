package com.example.demo.controller;

import com.example.demo.model.TierHistoryRecord;
import com.example.demo.service.TierUpgradeEngineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/engine")
public class TierUpgradeEngineController {

    private final TierUpgradeEngineService service;

    public TierUpgradeEngineController(TierUpgradeEngineService service) {
        this.service = service;
    }

    @PostMapping("/evaluate/{customerId}")
    public ResponseEntity<Void> evaluateAndUpgradeTier(@PathVariable Long customerId) {
        service.evaluateAndUpgradeTier(customerId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/history/customer/{customerId}")
    public ResponseEntity<List<TierHistoryRecord>> getHistoryByCustomer(@PathVariable Long customerId) {
        return ResponseEntity.ok(service.getHistoryByCustomer(customerId));
    }

    @GetMapping("/history")
    public List<TierHistoryRecord> getAllHistory() {
        return service.getAllHistory();
    }
}
