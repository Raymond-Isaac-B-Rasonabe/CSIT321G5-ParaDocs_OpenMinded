package com.csit321g5.paradocs.openminded.controller;

import com.csit321g5.paradocs.openminded.entity.LessonNote;
import com.csit321g5.paradocs.openminded.service.LessonNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lesson-notes")
@CrossOrigin
public class LessonNoteController {

    @Autowired
    LessonNoteService service;

    @PostMapping
    public LessonNote postLessonNote(@RequestBody LessonNote lessonNote) {
        return service.postLessonNote(lessonNote);
    }

    @GetMapping
    public List<LessonNote> getAllLessonNote() {
        return service.getAllLessonNote();
    }

    @GetMapping("/{id}")
    public LessonNote getLessonNoteById(@PathVariable Long id) {
        return service.getLessonNoteById(id);
    }

    @PutMapping("/{id}")
    public LessonNote putLessonNote(@PathVariable Long id, @RequestBody LessonNote lessonNote) {
        return service.putLessonNote(id, lessonNote);
    }

    @DeleteMapping("/{id}")
    public String deleteLessonNote(@PathVariable Long id) {
        return service.deleteLessonNote(id);
    }
}
