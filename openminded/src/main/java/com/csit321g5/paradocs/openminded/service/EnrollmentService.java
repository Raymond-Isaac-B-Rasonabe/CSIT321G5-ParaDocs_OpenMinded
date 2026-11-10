package com.csit321g5.paradocs.openminded.service;

import com.csit321g5.paradocs.openminded.entity.Enrollment;
import com.csit321g5.paradocs.openminded.repository.EnrollmentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EnrollmentService {

    @Autowired
    EnrollmentRepository repo;

    // CREATE
    public Enrollment postEnrollment(Enrollment enrollment) {
        return repo.save(enrollment);
    }

    // READ ALL
    public List<Enrollment> getAllEnrollment() {
        return repo.findAll();
    }

    // READ ONE
    public Enrollment getEnrollmentById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Enrollment " + id + " not found"));
    }

    // UPDATE
    public Enrollment putEnrollment(Long id, Enrollment newDetails) {
        Enrollment existing = getEnrollmentById(id);
        BeanUtils.copyProperties(newDetails, existing, "id");
        return repo.save(existing);
    }

    // DELETE
    public String deleteEnrollment(Long id) {
        if (!repo.existsById(id)) {
            throw new NoSuchElementException("Enrollment " + id + " not found");
        }
        repo.deleteById(id);
        return "Enrollment " + id + " deleted";
    }
}
