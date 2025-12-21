package com.example.demo.controller;

import com.example.demo.model.TierUpgradeRule;
import com.example.demo.service.TierUpgradeRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class TierUpgradeRuleController {

    @Autowired
    private TierUpgradeRuleService service;

    @PostMapping
    public TierUpgradeRule createRule(@RequestBody TierUpgradeRule rule) {
        return service.createRule(rule);
    }

    @PutMapping("/{id}")
    public TierUpgradeRule updateRule(@PathVariable Long id, @RequestBody TierUpgradeRule rule) {
        return service.updateRule(id, rule);
    }

    @DeleteMapping("/{id}")
    public void deleteRule(@PathVariable Long id) {
        service.deleteRule(id);
    }

    @GetMapping
    public List<TierUpgradeRule> getAllRules() {
        return service.getAllRules();
    }

    @GetMapping("/active")
    public List<TierUpgradeRule> getActiveRules() {
        return service.getActiveRules();
    }
}
