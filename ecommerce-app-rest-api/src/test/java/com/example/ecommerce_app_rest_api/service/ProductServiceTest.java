package com.example.ecommerce_app_rest_api.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ecommerce_app_rest_api.model.Product;
import com.example.ecommerce_app_rest_api.repository.ProductRepository;

@SpringBootTest
class ProductServiceTest {
	
	@Mock
	ProductRepository productRepository;
	
	@InjectMocks
	ProductService productService;
	
	private Product product;
	
	@BeforeEach
	public void setUp() {
		//Arrange
		product = new Product();
		product.setName("Laptops");
		product.setPrice(56.30);
	}

	@Test
	void testCreateProduct() {
	//	product = new Pro
		//Set up mockito behviour - stubbing 
        Mockito.when(productRepository.save(Mockito.any(Product.class))).thenReturn(product);

        
      //Action - Making the real call - action 
        Product savedProduct = productService.createProduct(product);
        System.out.println("Saved Product inside - testCreateProduct "+savedProduct);

        //Assert - junit assertions
        assertNotNull(savedProduct);
        assertEquals("Laptops", savedProduct.getName());
		
	}

	@Test
	void testGetProductByName() {
		//Set up mockito behviour - stubbing 
        Mockito.when(productRepository.findByName("Laptops")).thenReturn(Optional.of(product));

        
      //Action - Making the real call - action 
        Product fetchedProduct = productService.getProductByName("Laptops").get();
        System.out.println("Fetched  Product inside - testGetProductByName "+fetchedProduct);

        //Assert - junit assertions
        assertNotNull(fetchedProduct);
        assertEquals("Laptops", fetchedProduct.getName());
	}

	@Test
	void testGetProductById() {
		//Set up mockito behviour - stubbing 
        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        
      //Action - Making the real call - action 
        Product fetchedProduct = productService.getProductById(1L).get();
        System.out.println("Fetched  Product inside - testGetProductById "+fetchedProduct);

        //Assert - junit assertions
        assertNotNull(fetchedProduct);
     //   assertEquals(1L, fetchedProduct.getId());
	}

}
