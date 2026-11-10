package com.csit321g5.paradocs.openminded.controller;

import com.csit321g5.paradocs.openminded.entity.Section;
import com.csit321g5.paradocs.openminded.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sections")
@CrossOrigin
public class SectionController {

    @Autowired
    SectionService service;

    @PostMapping
    public Section postSection(@RequestBody Section section) {
        return service.postSection(section);
    }

    @GetMapping
    public List<Section> getAllSection() {
        return service.getAllSection();
    }

    @GetMapping("/{id}")
    public Section getSectionById(@PathVariable Long id) {
        return service.getSectionById(id);
    }

    @PutMapping("/{id}")
    public Section putSection(@PathVariable Long id, @RequestBody Section section) {
        return service.putSection(id, section);
    }

    @DeleteMapping("/{id}")
    public String deleteSection(@PathVariable Long id) {
        return service.deleteSection(id);
    }
}
