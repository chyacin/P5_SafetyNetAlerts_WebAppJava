package com.openclassroom.safetynetalerts.datafile.controller;

import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import com.jsoniter.JsonIterator;
import com.jsoniter.any.Any;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
	

	
public class Json_to_Java_Persons {

		public static void main(String[] args) {
			ClassLoader classLoader = new Json_to_Java_Persons().getClass().getClassLoader();
			String fileName = "src/main/resources/personsdata.json";
			File file = new File(classLoader.getResource(fileName).getFile());

			JSONParser parser = new JSONParser();
			try {
				FileReader reader = new FileReader(file.getAbsolutePath());
				byte[] bytesFile = Files.readAllBytes(new File(fileName).toPath());
				JsonIterator iter = JsonIterator.parse(bytesFile);
				Object obj = parser.parse(reader);
				JSONObject jsonObj = (JSONObject) obj;
				JSONObject persons = (JSONObject)jsonObj.get("persons");
				System.out.println("persons :"+persons.toJSONString());
				
				String personsFirstName = (String)persons.get("firstName");
				String personsLastName = (String)persons.get("lastName");
				String personsAddress = (String)persons.get("address");
				String personsCity = (String)persons.get("city");
				String personsZip = (String)persons.get("zip");
				String personsPhone = (String)persons.get("phone");
				String personsEmail = (String)persons.get("email");
				
				System.out.println("personsFirstName :"+personsFirstName);
				System.out.println("personsLastName :"+personsLastName);
				System.out.println("personsAddress :"+personsAddress);
				System.out.println("personsCity :"+personsCity);
				System.out.println("personsZip :"+personsZip);
				System.out.println("personsPhone :"+personsPhone);
				System.out.println("personsEmail :"+personsEmail);
				
				JSONArray personsList = (JSONArray)persons.get("persons");
				System.out.println("PersonsList :"+persons);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
