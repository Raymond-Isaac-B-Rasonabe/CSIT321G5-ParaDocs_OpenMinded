package com.csit321g5.paradocs.openminded.repository;

import com.csit321g5.paradocs.openminded.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
