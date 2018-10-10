package com.daniel.api.test;

import static com.jayway.restassured.RestAssured.given;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
 
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.daniel.api.Config;
import com.daniel.api.controllers.VehicleController;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import junit.framework.Assert;
import net.minidev.json.JSONObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class, loader = AnnotationConfigWebContextLoader.class)
@WebAppConfiguration
public class TestCases {
	
	/*@Autowired WebApplicationContext wac; 
	
	private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

	@Test
	public void initialEmptyVehicles() throws Exception{
		mockMvc.perform(get("/vehicles"))
        .andExpect(status().isNotFound());
	}*/

	private String baseURI = "http://localhost/vehicles";
	// Test that H2 database gets empty created initially and find empty list of vehicles
	// when retrieving all vehicles, with custom 404 status
	@Test
	public void initialEmptyVehiclesAnd404() {
		RestAssured.baseURI = baseURI;
		RequestSpecification request = RestAssured.given();

		Response response = request.get();
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 404);
		String bodyMessage = response.jsonPath().get("message");
		Assert.assertEquals( "Vehicles not found", bodyMessage);
	}

	@Test
	public void createCarVehicle() {
		RestAssured.baseURI = baseURI;
		RequestSpecification request = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("make", "Ford"); 
		requestParams.put("year", "2014");
		requestParams.put("color", "Blue");
		requestParams.put("capacity", "5");
		requestParams.put("wheels",  "4");
		requestParams.put("maxDriveSpeed",  "120");
		request.header("Content-Type", "application/json");
		
		request.body(requestParams.toJSONString());
		Response response = request.post("/car");
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 201);
	}

	@Test
	public void updateVehicle() {
		RestAssured.baseURI = baseURI;
		RequestSpecification request = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("make", "Ford"); 
		requestParams.put("year", "2015");
		requestParams.put("color", "Green");
		requestParams.put("capacity", "6");
		requestParams.put("maxDriveSpeed",  "160");
		request.header("Content-Type", "application/json");
		
		request.body(requestParams.toJSONString());
		Response response = request.put("/1");
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}

	@Test
	public void createTruckVehicle() {
		RestAssured.baseURI = baseURI;
		RequestSpecification request = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("make", "Lobo"); 
		requestParams.put("year", "2017");
		requestParams.put("color", "Black");
		requestParams.put("capacity", "6");
		requestParams.put("wheels",  "4");
		requestParams.put("maxDriveSpeed",  "200");
		requestParams.put("maxCarryWeight",  "500");
		request.header("Content-Type", "application/json");
		
		request.body(requestParams.toJSONString());
		Response response = request.post("/truck");
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 201);
	}
	
	@Test
	public void retrieveAllTypeOfVehicles() {
		RestAssured.baseURI = baseURI;
		RequestSpecification request = RestAssured.given();

		Response response = request.get();
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		response.then().body("", hasItems("CAR", "TRUCK"));
	}

	@Test
	public void deleteTruck() {
		RestAssured.baseURI = baseURI;
		RequestSpecification request = RestAssured.given();

		Response response = request.delete("/1");
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}

}
