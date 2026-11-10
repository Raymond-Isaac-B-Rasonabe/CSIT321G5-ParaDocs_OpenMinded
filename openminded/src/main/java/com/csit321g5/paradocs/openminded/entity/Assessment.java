package com.csit321g5.paradocs.openminded.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.*;

@Data
@Entity
@Table(name = "assessment")
public class Assessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assessment_id")
    private Long id;

    @ManyToOne @JoinColumn(name="section_id")
    private Section section;

    private String type;

    private String topic;

    private String title;

    private Double maxScore;

    private LocalDate dateGiven;
}
