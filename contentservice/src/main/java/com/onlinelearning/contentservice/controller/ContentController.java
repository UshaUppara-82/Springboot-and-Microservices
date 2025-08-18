package com.onlinelearning.contentservice.controller;

import com.onlinelearning.contentservice.model.ContentItem;
import com.onlinelearning.contentservice.repository.ContentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contents")
public class ContentController {

    private final ContentRepository repo;
    public ContentController(ContentRepository repo) { this.repo = repo; }

    @GetMapping
    public List<ContentItem> all() { return repo.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<ContentItem> one(@PathVariable Long id) {
        return repo.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/course/{courseId}")
    public List<ContentItem> byCourse(@PathVariable Long courseId) {
        return repo.findByCourseId(courseId);
    }

    @PostMapping
    public ContentItem create(@RequestBody ContentItem ci) { return repo.save(ci); }

    @PutMapping("/{id}")
    public ResponseEntity<ContentItem> update(@PathVariable Long id, @RequestBody ContentItem in) {
        return repo.findById(id).map(ci -> {
            ci.setCourseId(in.getCourseId());
            ci.setTitle(in.getTitle());
            ci.setContentType(in.getContentType());
            ci.setUrl(in.getUrl());
            ci.setText(in.getText());
            return ResponseEntity.ok(repo.save(ci));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

