package com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


import com.jsoniter.JsonIterator;
import com.jsoniter.any.Any;
import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.model.FireStation;
import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.model.MedicalRecord;
import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.model.Person;


public class ParseJsonData {

	
	
	public static void main(String[] args) throws IOException, NoSuchFieldException, SecurityException  {
		
	      
		String fileName = "src/main/resources/Data.json";
		   
		     byte[] bytesFile = Files.readAllBytes(new File(fileName).toPath());
		     JsonIterator iter = JsonIterator.parse(bytesFile);
		  
		     
		     Any any = iter.readAny();
		     
		     Any personAny = any.get("persons");
		     
		     
		     //Person Data
		     
		     personAny.forEach(a -> ApplicationData.persons.add(new Person.PersonBuilder()
		    		  .firstName(a.get("firstName").toString())
		    		  .address(a.get("address").toString())
		    		  .city(a.get("city").toString())
		    		  .lastName(a.get("lastName").toString())
		    		  .phone(a.get("phone").toString())
		    		  .zip(a.get("zip").toString())
		    		  .email(a.get("email").toString())
		    		  .build()));
		     
		     
		     ApplicationData.persons.forEach(p -> System.out.println(p.firstName
		    		.concat(p.lastName).concat(p.address)
		    		.concat(p.city)
		    		.concat(p.phone)
		    		.concat(p.zip)));
		     
		     
		     //Fire Station Data
		     
		  Map<String, FireStation> fireStationMap = new HashMap<>();
		     
		  Any fireStationAny = any.get("firestations");
		     
		     
		     fireStationAny.forEach(anyStation -> { 
		    	 fireStationMap.compute(anyStation.get("station").toString(), 
		    	 (k, v) -> v == null ?
		    	 new FireStation(anyStation.get("station").toString())
		    	 .addAddress(anyStation.get("address").toString()) :
		    	 v.addAddress(anyStation.get("address").toString()));
		    	 });
		     
		   ApplicationData.fireStations = fireStationMap.values()
		    		       .stream()
		    		       .collect(Collectors.toList());
		     
		   ApplicationData.fireStations.forEach(firestation -> 
		               System.out.println("Firestation " + firestation.toString()));
		     
	     
		     
		     
		  // Medical Records Data
		   
		Any medicalAny = any.get("medicalrecords");

		medicalAny.forEach(AnyMedicalRecord -> {MedicalRecord medicalRecord = new MedicalRecord(
		         AnyMedicalRecord.get("firstName").toString(),
		         AnyMedicalRecord.get("lastName").toString(),
		         AnyMedicalRecord.get("birthdate").toString());

		     Any medications = AnyMedicalRecord.get("medications");
		     if(medications.size() > 0)
		     medications.forEach(a -> medicalRecord.addMedication(a.toString()));

		     Any allergies = AnyMedicalRecord.get("allergies");
		     if(allergies.size() > 0)
		     allergies.forEach(a -> medicalRecord.addAllergies(a.toString()));

		     ApplicationData.medicalRecords.add(medicalRecord);});

		     ApplicationData.medicalRecords.forEach(medicalRecord -> 
		     System.out.println("medicalRecord " + medicalRecord.toString()));
		          
      
	}   
}
