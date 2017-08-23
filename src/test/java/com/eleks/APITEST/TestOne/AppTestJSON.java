package com.eleks.APITEST.TestOne;

import java.io.IOException;
import java.net.URISyntaxException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static com.eleks.APITEST.TestOne.App.*;
import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class AppTestJSON{	
	
	@BeforeClass
	public void setUp(){
		baseURI = "http://localhost:3000/";
				
	}
	
	@Test()
	public void TC_001_Json_001() throws URISyntaxException, IOException {
		
		String aj = get(TestData.Сompanies+1).asString();
		System.out.println(aj);
				
		WriteJsonToFile(aj, TestData.FileName);

	}
	
	@Test
	public void TC_002_Json_002(){
		FileReader(TestData.FileName);
				
	}
	
	@Test
	public void TC_003_Json_003(){
		given().get("/companies").then().body("name", hasItems("Eleks"));
	}
	
	@Test
	public void TC_004_Json_004(){
		given().body(TestData.NewEmployee).when().post(TestData.Employees).then().statusCode(201).log().all();
	}
	
	@Test
	public void TC_005_Json_005(){
		given().delete("/employees/5");
		System.out.println(given().get("/employees").asString());
		
	}
}
