package com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.service;

import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.model.Person;
import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.utility.ApplicationData;


public class PersonService {
	
	//ENDPOINTS(person)

	public static void updatePerson(Person newPerson) {
   	 
    	for(Person person: ApplicationData.persons) {
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
		 
		 for(Person person: ApplicationData.persons) {
				if(person.getFirstName().equals(firstName)
				   && person.getLastName().equals(lastName)) {
					
				ApplicationData.persons.remove(person);
				}
		}
		 
	}
}
