package com.example.demo.controller;

import com.example.demo.model.TierUpgradeRule;
import com.example.demo.service.TierUpgradeRuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class TierUpgradeRuleController {

    private final TierUpgradeRuleService service;

    public TierUpgradeRuleController(TierUpgradeRuleService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TierUpgradeRule> createRule(@RequestBody TierUpgradeRule rule) {
        return ResponseEntity.ok(service.createRule(rule));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TierUpgradeRule> updateRule(@PathVariable Long id, @RequestBody TierUpgradeRule rule) {
        return ResponseEntity.ok(service.updateRule(id, rule));
    }

    @GetMapping("/active")
    public List<TierUpgradeRule> getActiveRules() {
        return service.getActiveRules();
    }
}
