package com.onlinelearning.enrollmentservice.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "enrollments",
       uniqueConstraints = @UniqueConstraint(columnNames = {"userId","courseId"}))
public class Enrollment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long courseId;

    private LocalDateTime enrolledAt;

    public Enrollment() {}
    public Enrollment(Long userId, Long courseId) {
        this.userId = userId;
        this.courseId = courseId;
        this.enrolledAt = LocalDateTime.now();
    }

    @PrePersist
    public void prePersist() {
        if (enrolledAt == null) enrolledAt = LocalDateTime.now();
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public Long getUserId() {return userId;}
    public void setUserId(Long userId) {this.userId = userId;}
    public Long getCourseId() {return courseId;}
    public void setCourseId(Long courseId) {this.courseId = courseId;}
    public LocalDateTime getEnrolledAt() {return enrolledAt;}
    public void setEnrolledAt(LocalDateTime enrolledAt) {this.enrolledAt = enrolledAt;}
}

