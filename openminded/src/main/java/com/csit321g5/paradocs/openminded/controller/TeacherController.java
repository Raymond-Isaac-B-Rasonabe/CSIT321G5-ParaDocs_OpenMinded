package com.csit321g5.paradocs.openminded.controller;

import com.csit321g5.paradocs.openminded.entity.Teacher;
import com.csit321g5.paradocs.openminded.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
@CrossOrigin
public class TeacherController {

    @Autowired
    TeacherService service;

    @PostMapping
    public Teacher postTeacher(@RequestBody Teacher teacher) {
        return service.postTeacher(teacher);
    }

    @GetMapping
    public List<Teacher> getAllTeacher() {
        return service.getAllTeacher();
    }

    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable Long id) {
        return service.getTeacherById(id);
    }

    @PutMapping("/{id}")
    public Teacher putTeacher(@PathVariable Long id, @RequestBody Teacher teacher) {
        return service.putTeacher(id, teacher);
    }

    @DeleteMapping("/{id}")
    public String deleteTeacher(@PathVariable Long id) {
        return service.deleteTeacher(id);
    }
}
