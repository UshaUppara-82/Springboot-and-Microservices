package com.onlinelearning.courseservice.controller;

import com.onlinelearning.courseservice.model.Course;
import com.onlinelearning.courseservice.Repository.CourseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseRepository repo;
    public CourseController(CourseRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Course> all() { return repo.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Course> one(@PathVariable Long id) {
        return repo.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public List<Course> search(@RequestParam String q) {
        return repo.findByTitleContainingIgnoreCase(q);
    }

    @GetMapping("/instructor/{instructorId}")
    public List<Course> byInstructor(@PathVariable Long instructorId) {
        return repo.findByInstructorId(instructorId);
    }

    @PostMapping
    public Course create(@RequestBody Course c) { return repo.save(c); }

    @PutMapping("/{id}")
    public ResponseEntity<Course> update(@PathVariable Long id, @RequestBody Course in) {
        return repo.findById(id).map(c -> {
            c.setTitle(in.getTitle());
            c.setDescription(in.getDescription());
            c.setInstructorId(in.getInstructorId());
            return ResponseEntity.ok(repo.save(c));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
