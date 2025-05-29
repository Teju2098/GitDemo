package com.studentapp.junit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;


@RunWith(SerenityRunner.class)
public class FirstAssignment {
	
	static String countryName = "India";
	
	@Test
	public void getCountries() {
		String responceBody = RestAssured.given()
		.when()
		.get("http://api.countrylayer.com/v2/name/India?access_key=9b57437e92ee2c61c34235c9c905dbda&fullText=")
		.getBody()
		.asString();
		System.out.println("Responce:");
		System.out.println(responceBody);
		Assert.assertTrue(responceBody.contains("Republic Of India"));
		//checking
		
	 }
	

}
