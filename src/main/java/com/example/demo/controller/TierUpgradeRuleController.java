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

    @PostMapping
    public TierUpgradeRule createRule(@RequestBody TierUpgradeRule rule) {
        return ruleService.createRule(rule);
    }

    @PutMapping("/{id}")
    public TierUpgradeRule updateRule(
            @PathVariable Long id,
            @RequestBody TierUpgradeRule rule) {
        return ruleService.updateRule(id, rule);
    }

    @GetMapping("/{id}")
    public TierUpgradeRule getRule(@PathVariable Long id) {
        return ruleService.getRuleById(id);
    }

    @GetMapping("/active")
    public List<TierUpgradeRule> getActiveRules() {
        return ruleService.getActiveRules();
    }

    @GetMapping
    public List<TierUpgradeRule> getAllRules() {
        return ruleService.getAllRules();
    }
}
