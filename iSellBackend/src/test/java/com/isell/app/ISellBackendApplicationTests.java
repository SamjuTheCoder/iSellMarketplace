package com.isell.app;

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
import com.isell.app.controller.RestfulController;
import lombok.experimental.Wither;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebMvcTest(value = RestfulController.class)
@Wither

class ISellBackendApplicationTests {
	
	@Test
	public void getAllCategories() throws URISyntaxException {
	RestTemplate restTemplate = new RestTemplate();
    
    final String baseUrl = "http://localhost:8081/api/categories";
    URI uri = new URI(baseUrl);
 
    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
     
    //Verify request succeed
    Assert.assertEquals(200, result.getStatusCodeValue());
    Assert.assertEquals(true, result.getBody().contains("categoryList"));
	}
	
	@Test
	public void getCategoryById() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
	    
	    final String baseUrl = "http://localhost:8081/api/singlecategory/1";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	     
	    //Verify request succeed
	    Assert.assertEquals(200, result.getStatusCodeValue());
	    Assert.assertEquals(true, result.getBody().contains("categoryList"));
		}
	@Test
	public void getServiceProvider() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
	    
	    final String baseUrl = "http://localhost:8081/api/serviceprovider";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	     
	    //Verify request succeed
	    Assert.assertEquals(200, result.getStatusCodeValue());
	    Assert.assertEquals(true, result.getBody().contains("providerList"));
		}
	@Test
	public void getMeal() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
	    
	    final String baseUrl = "http://localhost:8081/api/meal";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	     
	    //Verify request succeed
	    Assert.assertEquals(200, result.getStatusCodeValue());
	    Assert.assertEquals(true, result.getBody().contains("mealList"));
		}
	@Test
	public void getServiceProviderById() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
	    
	    final String baseUrl = "http://localhost:8081/api/service/1";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	     
	    //Verify request succeed
	    Assert.assertEquals(200, result.getStatusCodeValue());
	    Assert.assertEquals(true, result.getBody().contains("providerList"));
		}
	@Test
	public void getProductDetails() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
	    
	    final String baseUrl = "http://localhost:8081/api/listingbycategory";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	     
	    //Verify request succeed
	    Assert.assertEquals(200, result.getStatusCodeValue());
	    Assert.assertEquals(true, result.getBody().contains("productList"));
		}
	@Test
	public void getProductDetailsByCity() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
	    
	    final String baseUrl = "http://localhost:8081/api/searchbycity/1/1";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	     
	    //Verify request succeed
	    Assert.assertEquals(200, result.getStatusCodeValue());
	    Assert.assertEquals(true, result.getBody().contains("productList"));
		}
	
	@Test
	public void getProductDetailsByName() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
	    
	    final String baseUrl = "http://localhost:8081/api/searchbyname/Food";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	     
	    //Verify request succeed
	    Assert.assertEquals(200, result.getStatusCodeValue());
	    Assert.assertEquals(true, result.getBody().contains("productList"));
		}


}
