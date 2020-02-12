package com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.service;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.model.MedicalRecord;
import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.model.Person;
import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.utility.ApplicationData;


public class PersonService {
	
	private List<Person> persons = ApplicationData.getPersons();
	
	//ENDPOINTS(person)

	public static void updatePerson(Person newPerson) {
   	 
    	for(Person person: persons) {
			if(person.getFirstName().equals(newPerson.firstName)
				   && person.getLastName().equals(newPerson.lastName)) {
					
				person.setAddress(newPerson.getAddress());
				person.setCity(newPerson.getCity());
				person.setEmail(newPerson.getEmail());
				person.setPhone(newPerson.getPhone());
				person.setZip(newPerson.getZip());
			}	
    	}	
    }


	 public static void deletePerson(String firstName, String lastName){
		 
		 for(Person person: persons) {
				if(person.getFirstName().equals(firstName)
				   && person.getLastName().equals(lastName)) {
					
				ApplicationData.persons.remove(person);
				}
		}
		 
	}
	 
	 public static String getPersonByName(String firstName, String lastName) {
	    	
		 for(Person person: persons) {
				if(person.getFirstName().equals(firstName)
				   && person.getLastName().equals(lastName)) {
					
					ApplicationData.persons.get(1);
				}
				
			}
	    	   return null;
	    }
	 
	//(URL)
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
		
	   
}
