package com.example.order_service.dto;

public class ProductDTO {
private Long id;
    
    private String name;
    private Double price;
    
 
    
    
    // Getters and Setters
    
    public ProductDTO() {
    	super();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

 

}
