package com.csit321g5.paradocs.openminded.service;

import com.csit321g5.paradocs.openminded.entity.Announcement;
import com.csit321g5.paradocs.openminded.repository.AnnouncementRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AnnouncementService {

    @Autowired
    AnnouncementRepository repo;

    // CREATE
    public Announcement postAnnouncement(Announcement announcement) {
        return repo.save(announcement);
    }

    // READ ALL
    public List<Announcement> getAllAnnouncement() {
        return repo.findAll();
    }

    // READ ONE
    public Announcement getAnnouncementById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Announcement " + id + " not found"));
    }

    // UPDATE
    public Announcement putAnnouncement(Long id, Announcement newDetails) {
        Announcement existing = getAnnouncementById(id);
        BeanUtils.copyProperties(newDetails, existing, "id");
        return repo.save(existing);
    }

    // DELETE
    public String deleteAnnouncement(Long id) {
        if (!repo.existsById(id)) {
            throw new NoSuchElementException("Announcement " + id + " not found");
        }
        repo.deleteById(id);
        return "Announcement " + id + " deleted";
    }
}
