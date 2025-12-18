package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.TierUpgradeRule;
import com.example.demo.service.TierUpgradeRuleService;

@RestController
@RequestMapping("/tier-rules")
public class TierUpgradeRuleController {

    @Autowired
    private TierUpgradeRuleService tierUpgradeRuleService;

    // ✅ Create / Add a tier rule
    @PostMapping
    public TierUpgradeRule createRule(@RequestBody TierUpgradeRule rule) {
        return tierUpgradeRuleService.save(rule);
    }

    // ✅ Get all tier rules
    @GetMapping
    public List<TierUpgradeRule> getAllRules() {
        return tierUpgradeRuleService.getAll();
    }

    // ✅ Get tier rule by ID
    @GetMapping("/{id}")
    public TierUpgradeRule getRuleById(@PathVariable Long id) {
        return tierUpgradeRuleService.getById(id);
    }

    // ✅ Delete tier rule
    @DeleteMapping("/{id}")
    public String deleteRule(@PathVariable Long id) {
        tierUpgradeRuleService.delete(id);
        return "Tier rule deleted successfully";
    }
}
