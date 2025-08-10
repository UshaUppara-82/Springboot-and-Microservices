package com.example.ecommerce_app_rest_api.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false) // enable and configure auto-configuration of MockMvc
class AppControllerTest {
	
	
	@Autowired // Mocking class tailored for testing the web layer, http methods
	private MockMvc mockMvc;


	@Test
	public void testCreateProduct() throws Exception {
		// Arrange
		String productJson = "{\r\n"
				+ "    \"name\" :  \"Mobiles\",\r\n"
				+ "    \"price\" : 860.00\r\n"
				+ "}";
		
		// Action
		ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/api/products")
				.contentType(MediaType.APPLICATION_JSON).content(productJson));

		System.out.println(result.toString());

		// Assert - 
		result.andExpect(status().isCreated()).andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Mobiles"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.price").value("860.0"));

	}



}
