
package com.onlinelearning.enrollmentservice.Controller;

import com.onlinelearning.enrollmentservice.model.Enrollment;
import com.onlinelearning.enrollmentservice.repository.EnrollmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    private final EnrollmentRepository repo;
    public EnrollmentController(EnrollmentRepository repo) { this.repo = repo; }

    // List
    @GetMapping
    public List<Enrollment> all() { return repo.findAll(); }

    // Get one
    @GetMapping("/{id}")
    public ResponseEntity<Enrollment> one(@PathVariable Long id) {
        return repo.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // By user
    @GetMapping("/user/{userId}")
    public List<Enrollment> byUser(@PathVariable Long userId) {
        return repo.findByUserId(userId);
    }

    // By course
    @GetMapping("/course/{courseId}")
    public List<Enrollment> byCourse(@PathVariable Long courseId) {
        return repo.findByCourseId(courseId);
    }

    // Enroll (idempotent: prevent duplicate)
    @PostMapping
    public ResponseEntity<Enrollment> enroll(@RequestBody Enrollment in) {
        return repo.findByUserIdAndCourseId(in.getUserId(), in.getCourseId())
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.ok(repo.save(in)));
    }

    @DeleteMapping
    public ResponseEntity<Void> unenroll(@RequestParam Long userId, @RequestParam Long courseId) {
        return repo.findByUserIdAndCourseId(userId, courseId)
                .map(enrollment -> {
                    repo.delete(enrollment);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

    