package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.TierUpgradeEngineService;

@RestController
@RequestMapping("/tier")
public class TierUpgradeEngineController {

    @Autowired
    private TierUpgradeEngineService service;

    @GetMapping("/upgrade/{id}")
    public String upgrade(@PathVariable Long id) {
        return service.upgradeTier(id);
    }
}
