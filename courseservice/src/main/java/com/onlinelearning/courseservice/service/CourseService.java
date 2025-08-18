package com.onlinelearning.courseservice.service;

import com.onlinelearning.courseservice.model.Course;
import com.onlinelearning.courseservice.Repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourse(Long id) {
        return courseRepository.findById(id);
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Optional<Course> updateCourse(Long id, Course courseDetails) {
        return courseRepository.findById(id).map(c -> {
            c.setTitle(courseDetails.getTitle());
            c.setDescription(courseDetails.getDescription());
            c.setInstructorId(courseDetails.getInstructorId());
            return courseRepository.save(c);
        });
    }

    public boolean deleteCourse(Long id) {
        return courseRepository.findById(id).map(c -> {
            courseRepository.delete(c);
            return true;
        }).orElse(false);
    }

    public List<Course> searchCourses(String q) {
        return courseRepository.findByTitleContainingIgnoreCase(q);
    }

    public List<Course> getByInstructor(Long instructorId) {
        return courseRepository.findByInstructorId(instructorId);
    }
}
