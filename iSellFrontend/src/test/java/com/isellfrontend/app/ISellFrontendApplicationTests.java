package com.isellfrontend.app;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.isellfrontend.app.controller.HomeController;


@SpringBootTest
@RunWith(SpringRunner.class)
@WebMvcTest(value = HomeController.class)
class ISellFrontendApplicationTests {

	@Test
	public void productDetails() throws URISyntaxException {
	RestTemplate restTemplate = new RestTemplate();
    
    final String baseUrl = "http://localhost:8081/product-details/1";
    URI uri = new URI(baseUrl);
 
    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
     
    //Verify request succeed
    Assert.assertEquals(200, result.getStatusCodeValue());
    Assert.assertEquals(true, result.getBody().contains("productList"));
	}
	
	@Test
	public void productDetailsByCategory() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
	    
	    final String baseUrl = "http://localhost:8080/more-details/1";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	     
	    //Verify request succeed
	    Assert.assertEquals(200, result.getStatusCodeValue());
	    Assert.assertEquals(true, result.getBody().contains("productList"));
		}
	
	@Test
	public void productDetailsByCity() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
	    
	    final String baseUrl = "http://localhost:8080/search";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	     
	    //Verify request succeed
	    Assert.assertEquals(200, result.getStatusCodeValue());
	    Assert.assertEquals(true, result.getBody().contains("productList"));
		}
	
	@Test
	public void getMealByName() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
	    
	    final String baseUrl = "http://localhost:8080/meal/name";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	     
	    //Verify request succeed
	    Assert.assertEquals(200, result.getStatusCodeValue());
	    Assert.assertEquals(true, result.getBody().contains("mealList"));
		}
	
}
