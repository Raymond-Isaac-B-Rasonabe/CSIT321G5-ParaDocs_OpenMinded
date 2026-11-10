package com.csit321g5.paradocs.openminded.controller;

import com.csit321g5.paradocs.openminded.entity.Score;
import com.csit321g5.paradocs.openminded.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scores")
@CrossOrigin
public class ScoreController {

    @Autowired
    ScoreService service;

    @PostMapping
    public Score postScore(@RequestBody Score score) {
        return service.postScore(score);
    }

    @GetMapping
    public List<Score> getAllScore() {
        return service.getAllScore();
    }

    @GetMapping("/{id}")
    public Score getScoreById(@PathVariable Long id) {
        return service.getScoreById(id);
    }

    @PutMapping("/{id}")
    public Score putScore(@PathVariable Long id, @RequestBody Score score) {
        return service.putScore(id, score);
    }

    @DeleteMapping("/{id}")
    public String deleteScore(@PathVariable Long id) {
        return service.deleteScore(id);
    }
}
