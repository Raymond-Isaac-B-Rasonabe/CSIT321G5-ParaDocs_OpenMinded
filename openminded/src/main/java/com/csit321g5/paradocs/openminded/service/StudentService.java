package com.csit321g5.paradocs.openminded.service;

import com.csit321g5.paradocs.openminded.entity.Student;
import com.csit321g5.paradocs.openminded.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentService {

    @Autowired
    StudentRepository repo;

    // CREATE
    public Student postStudent(Student student) {
        return repo.save(student);
    }

    // READ ALL
    public List<Student> getAllStudent() {
        return repo.findAll();
    }

    // READ ONE
    public Student getStudentById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Student " + id + " not found"));
    }

    // UPDATE
    public Student putStudent(Long id, Student newDetails) {
        Student existing = getStudentById(id);
        BeanUtils.copyProperties(newDetails, existing, "id");
        return repo.save(existing);
    }

    // DELETE
    public String deleteStudent(Long id) {
        if (!repo.existsById(id)) {
            throw new NoSuchElementException("Student " + id + " not found");
        }
        repo.deleteById(id);
        return "Student " + id + " deleted";
    }
}
