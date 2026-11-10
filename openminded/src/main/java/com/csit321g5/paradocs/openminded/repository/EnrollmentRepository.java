package com.csit321g5.paradocs.openminded.repository;

import com.csit321g5.paradocs.openminded.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}
