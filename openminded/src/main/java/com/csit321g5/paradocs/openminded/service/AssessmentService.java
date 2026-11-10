package com.csit321g5.paradocs.openminded.service;

import com.csit321g5.paradocs.openminded.entity.Assessment;
import com.csit321g5.paradocs.openminded.repository.AssessmentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AssessmentService {

    @Autowired
    AssessmentRepository repo;

    // CREATE
    public Assessment postAssessment(Assessment assessment) {
        return repo.save(assessment);
    }

    // READ ALL
    public List<Assessment> getAllAssessment() {
        return repo.findAll();
    }

    // READ ONE
    public Assessment getAssessmentById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Assessment " + id + " not found"));
    }

    // UPDATE
    public Assessment putAssessment(Long id, Assessment newDetails) {
        Assessment existing = getAssessmentById(id);
        BeanUtils.copyProperties(newDetails, existing, "id");
        return repo.save(existing);
    }

    // DELETE
    public String deleteAssessment(Long id) {
        if (!repo.existsById(id)) {
            throw new NoSuchElementException("Assessment " + id + " not found");
        }
        repo.deleteById(id);
        return "Assessment " + id + " deleted";
    }
}
