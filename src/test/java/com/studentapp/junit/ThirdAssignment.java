package com.studentapp.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ThirdAssignment {
	
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String email;
	
public ThirdAssignment(String firstName, String lastName, String userName, String password, String email ){
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}
	@Test
	public void createCustomer() {
		
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		
		String firstName = "Sowmya";
		String lastName = "Kolagani";
		String userName = "Skolagani02";
		String password = "SK021220";
		String email = "sowmyak898@email.com";
		
		
		ThirdAssignment customer = new ThirdAssignment(firstName,lastName, userName, password, email);
		
		Response  response = RestAssured.given()
		.contentType(ContentType.JSON)
		.when()
		.body(customer)
		.post();
		  Assert.assertEquals(response.getStatusCode(), 201);
		  Assert.assertTrue(response.getBody().asString().contains("Operation completed successfully"));
		  Assert.assertEquals(response.jsonPath().get("SuccessCode"), "OPERATION_SUCCESS");
				
	}
	
	@Test
	public void createASameCustomer() {
			
		String firstName = "Sowmya";
		String lastName = "Kolagani";
		String userName = "Skolagani02";
		String password = "SK021220";
		String email = "sowmyak898@email.com";
		ThirdAssignment customer = new ThirdAssignment(firstName,lastName, userName, password, email);
		
		Response  response = RestAssured.given()
		.contentType(ContentType.JSON)
		.when()
		.body(customer)
		.post();
		  Assert.assertEquals(response.getStatusCode(), 200);
		  Assert.assertEquals(response.jsonPath().get("SuccessCode"), "FAULT_USER_ALREADY_EXISTS");
	}

}
