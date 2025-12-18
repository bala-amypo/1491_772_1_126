package com.example.demo.controller;

import com.example.demo.entity.TierUpgradeRule;
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
        service.createRule(rule);
        return rule;
    }

    @PutMapping("/{id}")
    public TierUpgradeRule updateRule(@PathVariable Long id, @RequestBody TierUpgradeRule rule) {
        service.updateRule(id, rule);
        return rule;
    }

    @GetMapping
    public List<TierUpgradeRule> getAllRules() {
        return service.getAllRules();
    }
}
