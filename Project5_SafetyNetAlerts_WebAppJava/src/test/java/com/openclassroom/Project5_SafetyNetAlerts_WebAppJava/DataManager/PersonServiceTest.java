package com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.DataManager;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.model.Person;
import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.service.PersonService;
import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.utility.ApplicationData;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {

	@Mock
	PersonService personService;
	
	@InjectMocks
	ApplicationData applicationData;
	
	//PersonTest
	
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
		
		//Act
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
}
