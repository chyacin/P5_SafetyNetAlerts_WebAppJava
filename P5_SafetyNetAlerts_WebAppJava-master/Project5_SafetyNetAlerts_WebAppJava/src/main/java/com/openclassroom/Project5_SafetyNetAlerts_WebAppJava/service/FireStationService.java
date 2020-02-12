package com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.service;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.model.FireStation;
import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.model.Person;
import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.utility.ApplicationData;


public class FireStationService {

	
	  static List<FireStation> fireStations = ApplicationData.fireStations;
	   static List<Person> persons = ApplicationData.persons;    
	  
	  
	  
	        //ENDPOINTS
			//(fireStation)
			 
			 
			 public static void createFireStationAddressMapping(String stationNumber, String address) {
			    	
			    	for(FireStation fireStation: fireStations) {
						 if(fireStation.getStationNumber().equals(stationNumber)) {
							 
							 fireStation.addAddress(address);
					     }
				    }
			    }	 
			 
			 public static void updateAddressFireStationNumber(String stationNumber, String address) {
				 
				 for(FireStation fireStation: fireStations) {
					 if(fireStation.getAddresses().contains(address)) {
						 
						 fireStation.removeAddress(address);
						 
					 }
					 
				 }
				 
				 for(FireStation fireStation: fireStations) {
					 if(fireStation.getStationNumber().equals(stationNumber)) {
						 
						 fireStation.addAddress(address);
						 return;
					 }
				}
				 
				 FireStation fireStation = new FireStation(stationNumber);
				 fireStation.addAddress(address);
				 ApplicationData.fireStations.add(fireStation);
				 
			 }
			 
		
			 
		    public static void deleteFireStationAddressMapping(String stationNumber, String address) {
		    	
		    	for(FireStation fireStation: fireStations) {
					 if(fireStation.getStationNumber().equals(stationNumber)) {
						 
						 fireStation.removeAddress(address);
				     }
			    }
		    }	
		    
		    
		    public static FireStation getStationFromStationAddress(String address) {
		    	
		    	for(FireStation fireStation: fireStations) {
					 if(fireStation.getAddresses().contains(address)) {
						 
						 return fireStation;
					 }
			    }	
		    	return null;
		   }
		    
		   //URL
		  //(/fireStation)
			public static JSONObject getPersonDetailsFromFireStation(String stationNumber) {
					
				
			      JSONObject fireStationDetails = new JSONObject();
				    for(FireStation fireStation: fireStations) {
					  if(fireStation.getStationNumber().equals(stationNumber)) {
							
						 fireStationDetails.put("persons", fireStation.getPersonsInEachStation());
						 fireStationDetails.put("numberOfAdults", fireStation.getNumberOfAdults());
						 fireStationDetails.put("numberOfChildren", fireStation.getNumberOfChildren());
							
							  
					  }	
				 }
					  return fireStationDetails;
		   }
	
			
			

			//(/phoneAlert)
		    public static List<String> getPhoneNumbersFromFireStation(String stationNumber) {
					
					List<Person> personsInFireStation = new ArrayList<>();
					List<String> phoneNumbersOfEachPerson = new ArrayList<>();
					
					for(FireStation fireStation: fireStations) {
						if(fireStation.getStationNumber().equals(stationNumber)) {
						   personsInFireStation = fireStation.getPersonsInEachStation();
						  
						}	
					}
					for(Person person: personsInFireStation) {
						phoneNumbersOfEachPerson.add(person.getPhone());
					}
					  return phoneNumbersOfEachPerson;
				}
			
		    //(/fire)
			public static JSONObject getAddressFromEachStationNumber(String address) {
				
				    String stationNumber = null;
			       	JSONObject detailsFromStationAddress = new JSONObject();
				
				     for(FireStation fireStation: fireStations) {
				    	 if (fireStation.getAddresses().contains(address)){
				    		  stationNumber = fireStation.getStationNumber();
				    		 
				    	 }
				     }
				     	 
				    List<JSONObject> personsInAddress = new ArrayList<>();
				     
				    for(Person person: persons) {
				    
				       if(person.getAddress().equals(address)) {
				    	   
				    	JSONObject personInAddress = new JSONObject();
				    	   
				    	personInAddress.put("firstName", person.getFirstName());
				    	personInAddress.put("lastName", person.getLastName());
				    	personInAddress.put("phoneNumber", person.getPhone());
				    	personInAddress.put("age", person.getAge());
				    	personInAddress.put("medicationsWithDosage", person.getMedication());
				    	personInAddress.put("allergies", person.getAllergies());
				        
				        
				        personsInAddress.add(personInAddress);
				       }
				        
				    }
				    
				   detailsFromStationAddress.put("stationNumber", stationNumber);
				   detailsFromStationAddress.put("personsInAddress", personsInAddress);
				   
				   return detailsFromStationAddress;
				  }	     
				     
		     
			
			
			
			 //(/stations)
			 public static List<JSONObject> getHouseholdsPlusStation(String stationNumber) {
				 
				 List<String> addressesInFireStation = new ArrayList<>();
				 List<JSONObject> householdsWithPersons = new ArrayList<>();
				 
				 
				 for(FireStation fireStation: fireStations) {
					 if(fireStation.getStationNumber().equals(stationNumber)) {
						 addressesInFireStation.addAll(fireStation.getAddresses());
					 }
				 }
				 for (String address: addressesInFireStation) {
					 
					 JSONObject householdWithPersons = new JSONObject();
					 householdWithPersons.put("householdAddress", address);
					 
				 List<JSONObject> personsInHousehold = new ArrayList<>();
				 
				 for(Person person: persons) {
					 
					 if(person.getAddress().equals(address)) {
						 
						 JSONObject personInHousehold = new JSONObject();
						 
						 personInHousehold.put("firstName", person.getFirstName());
						 personInHousehold.put("lastName", person.getLastName());
						 personInHousehold.put("phoneNumber", person.getPhone());
						 personInHousehold.put("age", person.getAge());
						 personInHousehold.put("medicationsWithDosage", person.getMedication());
						 personInHousehold.put("allergies", person.getAllergies());
						 
						 personsInHousehold.add(personInHousehold);
					 }
					 
				 }
					 
				     householdWithPersons.put("personsInHousehold", personsInHousehold);
				     
				     householdsWithPersons.add(householdWithPersons);
				 }
				   
				    return householdsWithPersons;
				  
			 }
				  		
			
}
