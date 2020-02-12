package com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.DataManager;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.skyscreamer.jsonassert.JSONAssert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONException;
import org.json.simple.JSONObject;

import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.model.Person;
import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.service.PersonService;
import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.utility.ApplicationData;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {

	@Mock
	PersonService personService;
	
	@Mock
	Person person;
	
	@InjectMocks
	ApplicationData applicationData;
	
	//PersonServiceTest (EndPoints)
	
	@Test
	public void updatePerson_returnUpdatedperson() {
		
		//Arrange
		Person newPerson = new Person();
		newPerson.setFirstName("John");
		newPerson.setLastName("Boyd");
		newPerson.setAddress("237 Culver St");
		newPerson.setCity("Culver");
		newPerson.setZip("97451");
		newPerson.setPhone("841-874-7466");
		newPerson.setEmail("encore317@email.com");
		
				
	    PersonService.updatePerson(newPerson);
					
		//Assert
		assertEquals("237 Culver St", newPerson.getAddress());
		assertEquals("Culver", newPerson.getCity());
		assertEquals("97451", newPerson.getZip());
		assertEquals("841-874-7466", newPerson.getPhone());
		assertEquals("encore317@email.com", newPerson.getEmail());
		
	}
	
	@Test
	public void deletePerson_successfullyDeletedPerson(){
		
		//Arrange
		Person person = new Person();
		person.setFirstName("John");
		person.setLastName("Boyd");
		
		//Act
		PersonService.deletePerson("John", "Boyd");
		
		//Assert
		Mockito.verify(personService, times(1));	
		
	}
	
	//(URL)
	@Test
	public void jsonObject_getPersonInfo_returnPersonInfo()  {
		
		//Arrange
		 Set<String> medications = new HashSet<String>();
		  medications.add("aznol:350mg, hydrapermazol:100mg");
	
	     Set<String> allergies = new HashSet<>();
		  allergies.add("nilliacilan");
			
		 JSONObject personInfo = new JSONObject();	 
		 personInfo.put("John", person.getFirstName());
		 personInfo.put("Boyd", person.getLastName());
		 personInfo.put("1509 Culver St", person.getAddress().toString());	
		 personInfo.put("age", person.getAge());
		 personInfo.put("jaboyd@email.com", person.getEmail().toString());
		 personInfo.put("medicationsWithDosage", person.getMedication());
		 personInfo.put("allergies", person.getAllergies());
		
		//Act
		 List<JSONObject> newPersonInfo = PersonService.getPersonInfo("John", "Boyd");
		 
		 //Assert
		 assertEquals(personInfo, newPersonInfo);
		
		 	
	}
	
	
}
