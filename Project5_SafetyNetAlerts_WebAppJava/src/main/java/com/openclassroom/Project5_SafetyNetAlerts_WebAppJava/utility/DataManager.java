package com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.utility;

import java.util.ArrayList;
import java.util.List;


import org.json.simple.JSONObject;

import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.model.FireStation;
import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.model.MedicalRecord;
import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.model.Person;

public class DataManager {

	static List<Person> persons = ApplicationData.persons;
    static List<MedicalRecord> medicalRecords = ApplicationData.medicalRecords;
	static List<FireStation> fireStations = ApplicationData.fireStations;
			
	    
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
	
	//(/childAlert)
	public static JSONObject getChildrenFromEachAddress(String address) {
		
	  List<Person> personsInAddress = new ArrayList<>();
	  List<Person> adults = new ArrayList<>();
	  List<JSONObject> childrenDetails = new ArrayList<>();
		
		
		for(Person person: persons) {
			if(person.getAddress().equals(address)) {
				personsInAddress.add(person);
			}
		}
		for(Person person: personsInAddress) {
			if(person.getAge()<=18) {
		      JSONObject childDetails = new JSONObject();
		      childDetails.put("firstName", person.firstName);
		      childDetails.put("lastName", person.lastName);
		      childDetails.put("age", person.getAge());
		      
		      childrenDetails.add(childDetails);
			}
			else {
				adults.add(person);
			}
		}
		
		if(childrenDetails.isEmpty()) {
			return null;
		}
		else {
			JSONObject personsPlusChildrenDetails = new JSONObject();
			personsPlusChildrenDetails.put("childrenDetails", childrenDetails);
			personsPlusChildrenDetails.put("adults", adults);
			
			return personsPlusChildrenDetails;
		}
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
		  
    
 
	
	//(/personInfo)
	public static List <JSONObject> getPersonInfo(String firstName, String lastName) {
			
		 List <JSONObject> allPersonsInfo = new ArrayList<>();
			
			for(Person person: persons) {
				if(person.getFirstName().equals(firstName)
				   && person.getLastName().equals(lastName)) {
					
				   JSONObject personsInfo = new JSONObject();
					
				   personsInfo.put("firstName", person.getFirstName());
				   personsInfo.put("lastName", person.getLastName());
				   personsInfo.put("address", person.getAddress().toString());	
				   personsInfo.put("age", person.getAge());
				   personsInfo.put("email", person.getEmail().toString());
				   personsInfo.put("medicationsWithDosage", person.getMedication());
				   personsInfo.put("allergies", person.getAllergies());
				 	
				   allPersonsInfo.add(personsInfo);
				}	
			}
			     
			      return allPersonsInfo;
		}
	
	//(communityEmail)
   public static List<String> getPersonsEmailAddress(String city) {
			
		  List <String> personsEmailAddress = new ArrayList<>();
		   
		       for(Person person: persons) {
				   if(person.getCity().equals(city)) {
					personsEmailAddress.add(person.getEmail());	
					
				} 
			}
		       return personsEmailAddress;
		}

	
	
	

}
