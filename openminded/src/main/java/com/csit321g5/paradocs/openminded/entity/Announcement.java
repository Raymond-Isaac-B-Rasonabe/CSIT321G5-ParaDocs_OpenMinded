package com.csit321g5.paradocs.openminded.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.*;

@Data
@Entity
@Table(name = "announcement")
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "announcement_id")
    private Long id;

    @ManyToOne @JoinColumn(name="section_id")
    private Section section;

    @ManyToOne @JoinColumn(name="teacher_id")
    private Teacher teacher;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String body;

    private LocalDateTime postedAt;
}
