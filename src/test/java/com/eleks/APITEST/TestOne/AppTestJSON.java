package com.eleks.APITEST.TestOne;

import java.io.IOException;
import java.net.URISyntaxException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
}
