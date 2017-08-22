package com.eleks.APITEST.TestOne;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class AppTestXML {
	
	@BeforeClass
	public void setUp(){
		baseURI = "http://www.thomas-bayer.com";
		basePath ="/sqlrest";
				
	}

	@Test
	public void TC_001_XML001(){
		given().get("/CUSTOMER/11").then().body("CUSTOMER.CITY", equalTo("Chicago")).log().all();
	}
}
