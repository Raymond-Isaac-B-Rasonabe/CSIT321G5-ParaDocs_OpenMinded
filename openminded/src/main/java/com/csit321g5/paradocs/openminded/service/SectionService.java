package com.csit321g5.paradocs.openminded.service;

import com.csit321g5.paradocs.openminded.entity.Section;
import com.csit321g5.paradocs.openminded.repository.SectionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SectionService {

    @Autowired
    SectionRepository repo;

    // CREATE
    public Section postSection(Section section) {
        return repo.save(section);
    }

    // READ ALL
    public List<Section> getAllSection() {
        return repo.findAll();
    }

    // READ ONE
    public Section getSectionById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Section " + id + " not found"));
    }

    // UPDATE
    public Section putSection(Long id, Section newDetails) {
        Section existing = getSectionById(id);
        BeanUtils.copyProperties(newDetails, existing, "id");
        return repo.save(existing);
    }

    // DELETE
    public String deleteSection(Long id) {
        if (!repo.existsById(id)) {
            throw new NoSuchElementException("Section " + id + " not found");
        }
        repo.deleteById(id);
        return "Section " + id + " deleted";
    }
}
