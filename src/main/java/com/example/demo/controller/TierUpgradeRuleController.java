package com.example.demo.controller;

import com.example.demo.entity.TierUpgradeRule;
import com.example.demo.service.TierUpgradeRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tier-rules")
public class TierUpgradeRuleController {

    private final TierUpgradeRuleService tierUpgradeRuleService;

    @Autowired
    public TierUpgradeRuleController(TierUpgradeRuleService tierUpgradeRuleService) {
        this.tierUpgradeRuleService = tierUpgradeRuleService;
    }

    @PostMapping
    public void createRule(@RequestBody TierUpgradeRule rule) {
        tierUpgradeRuleService.createRule(rule);
    }

    @PutMapping("/{id}")
    public void updateRule(@PathVariable Long id, @RequestBody TierUpgradeRule updatedRule) {
        tierUpgradeRuleService.updateRule(id, updatedRule);
    }

    @GetMapping("/active")
    public Iterable<TierUpgradeRule> getActiveRules() {
        return tierUpgradeRuleService.getActiveRules();
    }

    @GetMapping
    public Iterable<TierUpgradeRule> getAllRules() {
        return tierUpgradeRuleService.getAllRules();
    }

    @GetMapping("/lookup")
    public TierUpgradeRule getRuleByFromToTier(@RequestParam String fromTier, @RequestParam String toTier) {
        return tierUpgradeRuleService.getRule(fromTier, toTier);
    }
}
