package com.csit321g5.paradocs.openminded.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "risk_flag")
public class RiskFlag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "risk_flag_id")
    private Long id;

    @ManyToOne @JoinColumn(name="student_id")
    private Student student;

    @ManyToOne @JoinColumn(name="section_id")
    private Section section;

    private Double riskScore;

    private String reason;
}
