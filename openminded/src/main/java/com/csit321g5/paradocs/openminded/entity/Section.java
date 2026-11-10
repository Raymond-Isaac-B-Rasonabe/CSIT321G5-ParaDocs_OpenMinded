package com.csit321g5.paradocs.openminded.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "section")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "section_id")
    private Long id;

    @ManyToOne @JoinColumn(name="teacher_id")
    private Teacher teacher;

    @ManyToOne @JoinColumn(name="admin_id")
    private Admin admin;

    private String courseCode;

    private String courseTitle;

    private String sectionName;

    private String term;
}
