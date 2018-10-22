package com.daniel.api.test;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import com.daniel.api.Config;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import junit.framework.Assert;
import net.minidev.json.JSONObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class, loader = AnnotationConfigWebContextLoader.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Ignore("Comment this and Run as JUnit Test after deployment") 
public class TestCases {
	
	private final String BASE_URI = "http://localhost:8080/vehiclesAPI/vehicles";
	
	/**
	 * Test that H2 database gets empty created initially and find empty list of vehicles
	 *  when retrieving all vehicles, with retrieved custom 404 status
	 */
	@Test
	public void test1_initialEmptyVehicles() {
		RestAssured.baseURI = BASE_URI;
		RequestSpecification request = RestAssured.given();

		Response response = request.get();
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 404);
		String bodyMessage = response.jsonPath().get("message");
		Assert.assertEquals( "Vehicles not found", bodyMessage);
	}

	/**
	 * Create a Vehicle of type Car and get an Status of 201
	 */
	@Test
	public void test2_createCarVehicle() {
		RestAssured.baseURI = BASE_URI;
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

	/**
	 * Send an object of Car, and an Id path param of 1, to update the vehicle created before; expect a 200
	 */
	@Test
	public void test3_updateVehicle() {
		RestAssured.baseURI = BASE_URI;
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

	/**
	 * Create a new Vehicle, this time of type Truck, expect a 201
	 */
	@Test
	public void test4_createTruckVehicle() {
		RestAssured.baseURI = BASE_URI;
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
	
	/**
	 * Get all vehicles, check it has a Car and a Truck in the list, and expect a 200
	 */
	@Test
	public void test5_retrieveAllTypeOfVehicles() {
		RestAssured.baseURI = BASE_URI;
		RequestSpecification request = RestAssured.given();

		Response response = request.get();
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		//response.then().body("", hasItems("CAR", "TRUCK"));
		String bodyAsString = response.getBody().asString();
		Assert.assertEquals(bodyAsString.contains("CAR"), true);
		Assert.assertEquals(bodyAsString.contains("TRUCK"), true);
	}

	/**
	 * Delete the last created Truck Vehicle, expect a 200
	 */
	@Test
	public void test6_deleteTruck() {
		RestAssured.baseURI = BASE_URI;
		RequestSpecification request = RestAssured.given();

		Response response = request.delete("/last");
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 204);
	}

	/**
	 * Delete the Car vehicle, found by Id param, expect a 200
	 */
	@Test
	public void test7_deleteCar() {
		RestAssured.baseURI = BASE_URI;
		RequestSpecification request = RestAssured.given();

		Response response = request.delete("/1");
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 204);
	}
}
