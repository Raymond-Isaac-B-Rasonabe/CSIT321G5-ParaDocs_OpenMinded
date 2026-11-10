package com.csit321g5.paradocs.openminded.controller;

import com.csit321g5.paradocs.openminded.entity.Announcement;
import com.csit321g5.paradocs.openminded.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/announcements")
@CrossOrigin
public class AnnouncementController {

    @Autowired
    AnnouncementService service;

    @PostMapping
    public Announcement postAnnouncement(@RequestBody Announcement announcement) {
        return service.postAnnouncement(announcement);
    }

    @GetMapping
    public List<Announcement> getAllAnnouncement() {
        return service.getAllAnnouncement();
    }

    @GetMapping("/{id}")
    public Announcement getAnnouncementById(@PathVariable Long id) {
        return service.getAnnouncementById(id);
    }

    @PutMapping("/{id}")
    public Announcement putAnnouncement(@PathVariable Long id, @RequestBody Announcement announcement) {
        return service.putAnnouncement(id, announcement);
    }

    @DeleteMapping("/{id}")
    public String deleteAnnouncement(@PathVariable Long id) {
        return service.deleteAnnouncement(id);
    }
}
