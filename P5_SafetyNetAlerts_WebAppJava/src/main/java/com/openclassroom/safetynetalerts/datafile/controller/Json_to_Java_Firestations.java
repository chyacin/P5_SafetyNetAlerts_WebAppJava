package com.openclassroom.safetynetalerts.datafile.controller;

import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.jsoniter.JsonIterator;

public class Json_to_Java_Firestations {

	
	public static void main(String[] args) {
		ClassLoader classLoader = new Json_to_Java_Persons().getClass().getClassLoader();
		String fileName = "src/main/resources/firestationsdata.json";
		File file = new File(classLoader.getResource(fileName).getFile());

		JSONParser parser = new JSONParser();
		try {
			FileReader reader = new FileReader(file.getAbsolutePath());
			byte[] bytesFile = Files.readAllBytes(new File(fileName).toPath());
			JsonIterator iter = JsonIterator.parse(bytesFile);
			Object obj = parser.parse(reader);
			JSONObject jsonObj = (JSONObject) obj;
			JSONObject firestations = (JSONObject)jsonObj.get("firestation");
			System.out.println("firestation :"+firestations.toJSONString());
			
			String firestationAddress = (String)firestations.get("address");
			String firestationStation = (String)firestations.get("station");
			
			
			System.out.println("firestationAddress :"+firestationAddress);
			System.out.println("firestationStation :"+firestationStation);
			
			
			JSONArray firestationList = (JSONArray)firestations.get("firestation");
			System.out.println("firestationList :"+firestations);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
