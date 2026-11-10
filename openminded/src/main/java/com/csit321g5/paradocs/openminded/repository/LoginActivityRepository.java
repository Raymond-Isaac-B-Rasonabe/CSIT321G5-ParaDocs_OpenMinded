package com.csit321g5.paradocs.openminded.repository;

import com.csit321g5.paradocs.openminded.entity.LoginActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginActivityRepository extends JpaRepository<LoginActivity, Long> {
}
