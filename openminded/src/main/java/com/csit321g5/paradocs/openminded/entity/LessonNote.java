package com.csit321g5.paradocs.openminded.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.*;

@Data
@Entity
@Table(name = "lesson_note")
public class LessonNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lesson_note_id")
    private Long id;

    @ManyToOne @JoinColumn(name="section_id")
    private Section section;

    private String title;

    private String fileUrl;

    private LocalDateTime uploadedAt;
}
