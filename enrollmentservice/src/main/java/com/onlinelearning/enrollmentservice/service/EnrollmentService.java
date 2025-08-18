package com.onlinelearning.enrollmentservice.service;

import com.onlinelearning.enrollmentservice.model.Enrollment;
import com.onlinelearning.enrollmentservice.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public List<Enrollment> getAll() {
        return enrollmentRepository.findAll();
    }

    public Optional<Enrollment> getOne(Long id) {
        return enrollmentRepository.findById(id);
    }

    public List<Enrollment> byUser(Long userId) {
        return enrollmentRepository.findByUserId(userId);
    }

    public List<Enrollment> byCourse(Long courseId) {
        return enrollmentRepository.findByCourseId(courseId);
    }

    public Enrollment enroll(Enrollment in) {
        return enrollmentRepository.findByUserIdAndCourseId(in.getUserId(), in.getCourseId())
                .orElse(enrollmentRepository.save(in));
    }

    public boolean unenroll(Long userId, Long courseId) {
        return enrollmentRepository.findByUserIdAndCourseId(userId, courseId).map(e -> {
            enrollmentRepository.delete(e);
            return true;
        }).orElse(false);
    }
}
