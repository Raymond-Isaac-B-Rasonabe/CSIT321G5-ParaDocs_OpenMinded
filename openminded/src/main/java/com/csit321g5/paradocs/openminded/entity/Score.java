package com.csit321g5.paradocs.openminded.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "score")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "score_id")
    private Long id;

    @ManyToOne @JoinColumn(name="assessment_id")
    private Assessment assessment;

    @ManyToOne @JoinColumn(name="student_id")
    private Student student;

    private Double score;
}
