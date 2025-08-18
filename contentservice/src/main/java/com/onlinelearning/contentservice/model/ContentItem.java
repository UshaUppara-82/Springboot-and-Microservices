
package com.onlinelearning.contentservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "content_items")
public class ContentItem {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long courseId;
    private String title;

    // e.g., VIDEO, ARTICLE, QUIZ
    private String contentType;

    // optional storage reference
    private String url;

    @Column(length = 8000)
    private String text; // use this for article text or notes

    public ContentItem() {}
    public ContentItem(Long courseId, String title, String contentType, String url, String text) {
        this.courseId = courseId;
        this.title = title;
        this.contentType = contentType;
        this.url = url;
        this.text = text;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public Long getCourseId() {return courseId;}
    public void setCourseId(Long courseId) {this.courseId = courseId;}
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public String getContentType() {return contentType;}
    public void setContentType(String contentType) {this.contentType = contentType;}
    public String getUrl() {return url;}
    public void setUrl(String url) {this.url = url;}
    public String getText() {return text;}
    public void setText(String text) {this.text = text;}
}

