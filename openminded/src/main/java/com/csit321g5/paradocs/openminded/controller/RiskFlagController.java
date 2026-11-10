package com.csit321g5.paradocs.openminded.controller;

import com.csit321g5.paradocs.openminded.entity.RiskFlag;
import com.csit321g5.paradocs.openminded.service.RiskFlagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/risk-flags")
@CrossOrigin
public class RiskFlagController {

    @Autowired
    RiskFlagService service;

    @PostMapping
    public RiskFlag postRiskFlag(@RequestBody RiskFlag riskFlag) {
        return service.postRiskFlag(riskFlag);
    }

    @GetMapping
    public List<RiskFlag> getAllRiskFlag() {
        return service.getAllRiskFlag();
    }

    @GetMapping("/{id}")
    public RiskFlag getRiskFlagById(@PathVariable Long id) {
        return service.getRiskFlagById(id);
    }

    @PutMapping("/{id}")
    public RiskFlag putRiskFlag(@PathVariable Long id, @RequestBody RiskFlag riskFlag) {
        return service.putRiskFlag(id, riskFlag);
    }

    @DeleteMapping("/{id}")
    public String deleteRiskFlag(@PathVariable Long id) {
        return service.deleteRiskFlag(id);
    }
}
