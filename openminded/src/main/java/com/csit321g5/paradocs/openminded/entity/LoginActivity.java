package com.csit321g5.paradocs.openminded.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.*;

@Data
@Entity
@Table(name = "login_activity")
public class LoginActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "login_activity_id")
    private Long id;

    @ManyToOne @JoinColumn(name="student_id")
    private Student student;

    private LocalDateTime loginTime;
}
