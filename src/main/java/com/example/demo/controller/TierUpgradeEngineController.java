package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.TierUpgradeRule;
import com.example.demo.service.TierUpgradeRuleService;

@RestController
@RequestMapping("/tier-rules")
public class TierUpgradeRuleController {

    private final TierUpgradeRuleService ruleService;

    public TierUpgradeRuleController(TierUpgradeRuleService ruleService) {
        this.ruleService = ruleService;
    }

    // Create rule
    @PostMapping
    public TierUpgradeRule createRule(@RequestBody TierUpgradeRule rule) {
        return ruleService.createRule(rule);
    }

    // Update rule
    @PutMapping("/{id}")
    public TierUpgradeRule updateRule(
            @PathVariable Long id,
            @RequestBody TierUpgradeRule rule) {
        return ruleService.updateRule(id, rule);
    }

    // Get rule by fromTier & toTier
    @GetMapping("/lookup")
    public TierUpgradeRule getRule(
            @RequestParam String fromTier,
            @RequestParam String toTier) {
        return ruleService.getRule(fromTier, toTier);
    }

    // Get active rules
    @GetMapping("/active")
    public List<TierUpgradeRule> getActiveRules() {
        return ruleService.getActiveRules();
    }

    // Get all rules
    @GetMapping
    public List<TierUpgradeRule> getAllRules() {
        return ruleService.getAllRules();
    }
}
