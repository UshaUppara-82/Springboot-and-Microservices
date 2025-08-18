package com.onlinelearning.contentservice.repository;

import com.onlinelearning.contentservice.model.ContentItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContentRepository extends JpaRepository<ContentItem, Long> {
    List<ContentItem> findByCourseId(Long courseId);
}
