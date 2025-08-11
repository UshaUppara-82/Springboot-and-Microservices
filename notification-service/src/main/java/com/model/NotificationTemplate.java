package com.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class NotificationTemplate {
	
	@Id
	private String id;// (UUID)
	private long templateId;
	private long templateName;// (String)
	private String content;// (String, supports placeholders)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getTemplateId() {
		return templateId;
	}
	public void setTemplateId(long templateId) {
		this.templateId = templateId;
	}
	public long getTemplateName() {
		return templateName;
	}
	public void setTemplateName(long templateName) {
		this.templateName = templateName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
