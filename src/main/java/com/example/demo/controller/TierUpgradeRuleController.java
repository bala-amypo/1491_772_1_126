package com.example.demo.controller;

import com.example.demo.model.TierUpgradeRule;
import com.example.demo.service.TierUpgradeRuleService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class TierUpgradeRuleController {

    private final TierUpgradeRuleService service;

    public TierUpgradeRuleController(TierUpgradeRuleService service) {
        this.service = service;
    }

    @PutMapping("/{id}")
    public TierUpgradeRule updateRule(@PathVariable Long id, @RequestBody TierUpgradeRule rule) {
        return service.updateRule(id, rule);
    }

    @GetMapping("/active")
    public List<TierUpgradeRule> getActiveRules() {
        return service.getActiveRules();
    }
}
