package com.csit321g5.paradocs.openminded.repository;

import com.csit321g5.paradocs.openminded.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
}
