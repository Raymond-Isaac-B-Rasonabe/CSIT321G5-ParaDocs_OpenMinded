package com.csit321g5.paradocs.openminded.service;

import com.csit321g5.paradocs.openminded.entity.Teacher;
import com.csit321g5.paradocs.openminded.repository.TeacherRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository repo;

    // CREATE
    public Teacher postTeacher(Teacher teacher) {
        return repo.save(teacher);
    }

    // READ ALL
    public List<Teacher> getAllTeacher() {
        return repo.findAll();
    }

    // READ ONE
    public Teacher getTeacherById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Teacher " + id + " not found"));
    }

    // UPDATE
    public Teacher putTeacher(Long id, Teacher newDetails) {
        Teacher existing = getTeacherById(id);
        BeanUtils.copyProperties(newDetails, existing, "id");
        return repo.save(existing);
    }

    // DELETE
    public String deleteTeacher(Long id) {
        if (!repo.existsById(id)) {
            throw new NoSuchElementException("Teacher " + id + " not found");
        }
        repo.deleteById(id);
        return "Teacher " + id + " deleted";
    }
}
