package com.onlinelearning.contentservice.service;

import com.onlinelearning.contentservice.model.ContentItem;
import com.onlinelearning.contentservice.repository.ContentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContentService {

    private final ContentRepository contentRepository;

    public ContentService(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    public List<ContentItem> getAll() {
        return contentRepository.findAll();
    }

    public Optional<ContentItem> getOne(Long id) {
        return contentRepository.findById(id);
    }

    public List<ContentItem> getByCourse(Long courseId) {
        return contentRepository.findByCourseId(courseId);
    }

    public ContentItem create(ContentItem ci) {
        return contentRepository.save(ci);
    }

    public Optional<ContentItem> update(Long id, ContentItem in) {
        return contentRepository.findById(id).map(ci -> {
            ci.setCourseId(in.getCourseId());
            ci.setTitle(in.getTitle());
            ci.setContentType(in.getContentType());
            ci.setUrl(in.getUrl());
            ci.setText(in.getText());
            return contentRepository.save(ci);
        });
    }

    public boolean delete(Long id) {
        return contentRepository.findById(id).map(ci -> {
            contentRepository.delete(ci);
            return true;
        }).orElse(false);
    }
}
