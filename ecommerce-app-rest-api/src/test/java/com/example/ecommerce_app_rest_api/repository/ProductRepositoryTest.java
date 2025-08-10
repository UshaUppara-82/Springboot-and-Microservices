package com.example.ecommerce_app_rest_api.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.ecommerce_app_rest_api.model.Product;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

class ProductRepositoryTest {
	
	@Autowired
	ProductRepository productRepository;
	
	
	@Test
	public void testSaveProduct() {
		//AAA
		
		//Arrange - creating the object
		Product p = new Product();
		p.setName("Pencils");
		p.setPrice(56.23);
		
		//Action - call repository method
		Product result = productRepository.save(p);
		
		//Assertion - compare the values actual and expected
		assertEquals(result.getName(), "Pencils");
		assertEquals(result.getPrice(), 56.23);
	}
	
	@Test
	public void testFindById() {

		//AAA
		
				//Arrange - creating the object
				Product p = new Product();
				p.setName("Pencils");
				p.setPrice(56.23);
				productRepository.save(p);

				
				//Action - call repository method
				Product result = productRepository.findById(1L).get();
				
				//Assertion - compare the values actual and expected
	//			assertEquals(result.getId(), 1L);
				
		
	}

	@Test
	void testFindByName() {
		
		//AAA
		
		//Arrange - creating the object
		Product p = new Product();
		p.setName("Pencils");
		p.setPrice(56.23);
		productRepository.save(p);

		
		//Action - call repository method
		Product result = productRepository.findByName("Pencils").get();
		
		//Assertion - compare the values actual and expected
		assertEquals(result.getName(), "Pencils");


	}
	
	
	

}
