package com.onlinelearning.courseservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 2000)
    private String description;

    // Optional: link to a user (instructor) by ID from user-service
    private Long instructorId;

    public Course() {}
    public Course(String title, String description, Long instructorId) {
        this.title = title;
        this.description = description;
        this.instructorId = instructorId;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public Long getInstructorId() {return instructorId;}
    public void setInstructorId(Long instructorId) {this.instructorId = instructorId;}
}
