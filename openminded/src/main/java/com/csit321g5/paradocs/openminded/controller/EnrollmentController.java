package com.csit321g5.paradocs.openminded.controller;

import com.csit321g5.paradocs.openminded.entity.Enrollment;
import com.csit321g5.paradocs.openminded.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
@CrossOrigin
public class EnrollmentController {

    @Autowired
    EnrollmentService service;

    @PostMapping
    public Enrollment postEnrollment(@RequestBody Enrollment enrollment) {
        return service.postEnrollment(enrollment);
    }

    @GetMapping
    public List<Enrollment> getAllEnrollment() {
        return service.getAllEnrollment();
    }

    @GetMapping("/{id}")
    public Enrollment getEnrollmentById(@PathVariable Long id) {
        return service.getEnrollmentById(id);
    }

    @PutMapping("/{id}")
    public Enrollment putEnrollment(@PathVariable Long id, @RequestBody Enrollment enrollment) {
        return service.putEnrollment(id, enrollment);
    }

    @DeleteMapping("/{id}")
    public String deleteEnrollment(@PathVariable Long id) {
        return service.deleteEnrollment(id);
    }
}
