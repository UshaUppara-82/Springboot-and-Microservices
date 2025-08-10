package com.mycompany.app;

public class Author {
	private String authorName;
	private String authorLocation;
	
	public Author() {
		System.out.println(" Inside Author constructor");
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorLocation() {
		return authorLocation;
	}

	public void setAuthorLocation(String authorLocation) {
		this.authorLocation = authorLocation;
	}

	@Override
	public String toString() {
		return "Author [authorName=" + authorName + ", authorLocation=" + authorLocation + "]";
	}
	
	
}
