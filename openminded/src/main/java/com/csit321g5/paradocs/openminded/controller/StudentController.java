package com.csit321g5.paradocs.openminded.controller;

import com.csit321g5.paradocs.openminded.entity.Student;
import com.csit321g5.paradocs.openminded.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin
public class StudentController {

    @Autowired
    StudentService service;

    @PostMapping
    public Student postStudent(@RequestBody Student student) {
        return service.postStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudent() {
        return service.getAllStudent();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return service.getStudentById(id);
    }

    @PutMapping("/{id}")
    public Student putStudent(@PathVariable Long id, @RequestBody Student student) {
        return service.putStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        return service.deleteStudent(id);
    }
}
