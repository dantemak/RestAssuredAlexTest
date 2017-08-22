package com.eleks.APITEST.TestOne;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestData {
	
	
	public static String FileName = "FirstOne";
	public static String Employees  = "employees";
	public static String Сompanies  = "companies";
	
	
		private static String PostReader(String FileName){
		String output = null;
		
		try(FileReader file = new FileReader("Jsons/Requests" + FileName +  ".txt")) {
			 output = file.toString();
			 System.out.println("Successfully Read Json file");
		} 
		catch (FileNotFoundException e) {e.printStackTrace();}
		catch (IOException e) {e.printStackTrace();}
		
		return output;
	}
	
}
