package com.csit321g5.paradocs.openminded.service;

import com.csit321g5.paradocs.openminded.entity.LessonNote;
import com.csit321g5.paradocs.openminded.repository.LessonNoteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LessonNoteService {

    @Autowired
    LessonNoteRepository repo;

    // CREATE
    public LessonNote postLessonNote(LessonNote lessonNote) {
        return repo.save(lessonNote);
    }

    // READ ALL
    public List<LessonNote> getAllLessonNote() {
        return repo.findAll();
    }

    // READ ONE
    public LessonNote getLessonNoteById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("LessonNote " + id + " not found"));
    }

    // UPDATE
    public LessonNote putLessonNote(Long id, LessonNote newDetails) {
        LessonNote existing = getLessonNoteById(id);
        BeanUtils.copyProperties(newDetails, existing, "id");
        return repo.save(existing);
    }

    // DELETE
    public String deleteLessonNote(Long id) {
        if (!repo.existsById(id)) {
            throw new NoSuchElementException("LessonNote " + id + " not found");
        }
        repo.deleteById(id);
        return "LessonNote " + id + " deleted";
    }
}
