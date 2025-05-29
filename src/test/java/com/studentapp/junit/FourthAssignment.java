package com.studentapp.junit;

import org.apache.http.HttpStatus;
import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;

public class FourthAssignment {
	public class AuthenticationRequestTest {
		 
	    @BeforeClass
	    public  void init()
	    {
	        RestAssured.baseURI ="http://restapi.demoqa.com";
	    }
	    
	    @Test
	    public void validLogin()
	    {
	    	RestAssured.given().auth()
	                .basic("validUser","validPassword")
	                .when()
	                .get("/authentication/CheckForAuthentication")
	                .then()
	                .assertThat()
	                .statusCode(HttpStatus.SC_OK)
	                .log()
	                .all(true);
	                
	    }
	    
	    @Test
	    public void InvalidLogin()
	    {
	    	RestAssured.given()
	    	.auth()
	        .basic("InvalidUser", "InvalidPassword")
	        .when()
	        .get("/authentication/CheckForAuthentication")
	         .then()
	          .assertThat()
	          .statusCode(HttpStatus.SC_UNAUTHORIZED)
	          .log()
	          .all(true);
	    }
  }

}
