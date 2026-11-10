package com.csit321g5.paradocs.openminded.service;

import com.csit321g5.paradocs.openminded.entity.RiskFlag;
import com.csit321g5.paradocs.openminded.repository.RiskFlagRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RiskFlagService {

    @Autowired
    RiskFlagRepository repo;

    // CREATE
    public RiskFlag postRiskFlag(RiskFlag riskFlag) {
        return repo.save(riskFlag);
    }

    // READ ALL
    public List<RiskFlag> getAllRiskFlag() {
        return repo.findAll();
    }

    // READ ONE
    public RiskFlag getRiskFlagById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("RiskFlag " + id + " not found"));
    }

    // UPDATE
    public RiskFlag putRiskFlag(Long id, RiskFlag newDetails) {
        RiskFlag existing = getRiskFlagById(id);
        BeanUtils.copyProperties(newDetails, existing, "id");
        return repo.save(existing);
    }

    // DELETE
    public String deleteRiskFlag(Long id) {
        if (!repo.existsById(id)) {
            throw new NoSuchElementException("RiskFlag " + id + " not found");
        }
        repo.deleteById(id);
        return "RiskFlag " + id + " deleted";
    }
}
