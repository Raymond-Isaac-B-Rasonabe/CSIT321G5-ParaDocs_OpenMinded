package com.csit321g5.paradocs.openminded.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "enrollment")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enrollment_id")
    private Long id;

    @ManyToOne @JoinColumn(name="section_id")
    private Section section;

    @ManyToOne @JoinColumn(name="student_id")
    private Student student;
}
