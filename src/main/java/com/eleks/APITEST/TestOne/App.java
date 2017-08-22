package com.eleks.APITEST.TestOne;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import io.restassured.http.ContentType;

public class App 
{
	public static String ReturnUri(String resource){
		
		String requestURI = resource;
		
		return requestURI;
		
	}
	
	public static String ReturnBodyAsString(String Path){
		return given().contentType(ContentType.JSON).when().get(Path).thenReturn().body().asString();
	}
	
	public static void WriteJsonToFile(String Json, String FileName) throws IOException{
		
		
		File newFile = new File("Jsons/" + FileName + ".json");
		
		if(!newFile.exists()){ newFile.createNewFile();}
		
		
		try (FileWriter file = new FileWriter("Jsons/" + FileName +  ".txt")) {
			file.write(Json);
			System.out.println("Successfully Copied JSON Object to File...");
			file.flush();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static String FileReader(String FileName){
		String output = null;
		
		try(FileReader file = new FileReader("Jsons/" + FileName +  ".txt")) {
			 output = file.toString();
			 System.out.println("Successfully Read Json file");
		} 
		catch (FileNotFoundException e) {e.printStackTrace();}
		catch (IOException e) {e.printStackTrace();}
		
		return output;
	}
}
