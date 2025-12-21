package com.example.demo.controller;

import com.example.demo.model.TierUpgradeRule;
import com.example.demo.service.TierUpgradeRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tier-rules")
public class TierUpgradeRuleController {

    private final TierUpgradeRuleService tierUpgradeRuleService;

    public TierUpgradeRuleController(TierUpgradeRuleService tierUpgradeRuleService) {
        this.tierUpgradeRuleService = tierUpgradeRuleService;
    }

    @PostMapping
    public TierUpgradeRule createRule(@RequestBody TierUpgradeRule rule) {
        return tierUpgradeRuleService.createRule(rule);
    }

    @PutMapping("/{id}")
    public TierUpgradeRule updateRule(@PathVariable Long id, @RequestBody TierUpgradeRule rule) {
        return tierUpgradeRuleService.updateRule(id, rule);
    }

    @GetMapping("/active")
    public List<TierUpgradeRule> getActiveRules() {
        return tierUpgradeRuleService.getActiveRules();
    }

    @GetMapping
    public List<TierUpgradeRule> getAllRules() {
        return tierUpgradeRuleService.getAllRules();
    }

    @GetMapping("/lookup")
    public TierUpgradeRule getRule(@RequestParam String fromTier, @RequestParam String toTier) {
        return tierUpgradeRuleService.getRule(fromTier, toTier);
    }
}
