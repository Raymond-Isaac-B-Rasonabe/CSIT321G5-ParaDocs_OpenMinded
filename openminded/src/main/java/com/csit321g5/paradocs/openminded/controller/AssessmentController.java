package com.csit321g5.paradocs.openminded.controller;

import com.csit321g5.paradocs.openminded.entity.Assessment;
import com.csit321g5.paradocs.openminded.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assessments")
@CrossOrigin
public class AssessmentController {

    @Autowired
    AssessmentService service;

    @PostMapping
    public Assessment postAssessment(@RequestBody Assessment assessment) {
        return service.postAssessment(assessment);
    }

    @GetMapping
    public List<Assessment> getAllAssessment() {
        return service.getAllAssessment();
    }

    @GetMapping("/{id}")
    public Assessment getAssessmentById(@PathVariable Long id) {
        return service.getAssessmentById(id);
    }

    @PutMapping("/{id}")
    public Assessment putAssessment(@PathVariable Long id, @RequestBody Assessment assessment) {
        return service.putAssessment(id, assessment);
    }

    @DeleteMapping("/{id}")
    public String deleteAssessment(@PathVariable Long id) {
        return service.deleteAssessment(id);
    }
}
