package com.mycompany.app;

public class Book {
	private Integer id;
	private String name;
	
	//private String authorName;
	//private String authorLocation;
	
	
	private Author author;
	
	
	
	public Book() {
		super();
	}

	//Constructor based injection - you have to create parameterised constructor with dependent object (author)
	public Book(Author author) {
		super();
		this.author = author;
		System.out.println(" Inside Book constructor - author");
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
	
	
}
