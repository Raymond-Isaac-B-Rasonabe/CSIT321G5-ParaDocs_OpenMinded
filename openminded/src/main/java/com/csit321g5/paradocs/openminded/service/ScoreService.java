package com.csit321g5.paradocs.openminded.service;

import com.csit321g5.paradocs.openminded.entity.Score;
import com.csit321g5.paradocs.openminded.repository.ScoreRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ScoreService {

    @Autowired
    ScoreRepository repo;

    // CREATE
    public Score postScore(Score score) {
        return repo.save(score);
    }

    // READ ALL
    public List<Score> getAllScore() {
        return repo.findAll();
    }

    // READ ONE
    public Score getScoreById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Score " + id + " not found"));
    }

    // UPDATE
    public Score putScore(Long id, Score newDetails) {
        Score existing = getScoreById(id);
        BeanUtils.copyProperties(newDetails, existing, "id");
        return repo.save(existing);
    }

    // DELETE
    public String deleteScore(Long id) {
        if (!repo.existsById(id)) {
            throw new NoSuchElementException("Score " + id + " not found");
        }
        repo.deleteById(id);
        return "Score " + id + " deleted";
    }
}
