package com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.DataManager;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.model.FireStation;
import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.model.MedicalRecord;
import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.model.Person;
import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.service.MedicalRecordService;
import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.utility.ApplicationData;
import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.utility.ParseJsonData;

@RunWith(MockitoJUnitRunner.class)
public class MedicalRecordServiceTest {
	
	@Mock
	MedicalRecordService medicalRecordService;
	
	@Mock
	MedicalRecord medicalRecord;

	@InjectMocks
	ApplicationData applicationData;
	
	 List<Person> persons = new ArrayList<>();
	 List<FireStation> fireStations = new ArrayList<>();
	 List<MedicalRecord> medicalRecords = new ArrayList<>();
	
	@Before
	public void setup() {
 
		 Person person = new Person("John", "Boyd", "888-987-7878", "75009", "175 Culver St", "Culver", "jaboyd@email.com");
		 FireStation fireStation = new FireStation("2");
		 MedicalRecord medicalRecord = new MedicalRecord("John", "Boyd", "03/07/84");
		 
		 persons.add(person);
		 fireStations.add(fireStation);
		 medicalRecords.add(medicalRecord);
		
	}
	
	
	
	@Test
	public void updatePersonMedicalRecord_returnUpdatedMedicalRecord() {
		

	    //Arrange
		Set<String> medications = new HashSet<String>();
		medications.add("pharmacol:750");
		
		Set<String> allergies = new HashSet<String>();
		allergies.add("shellfish");
		
		MedicalRecord newMedicalRecord = new MedicalRecord();
		newMedicalRecord.setFirstName("John");
		newMedicalRecord.setLastName("Boyd");
		newMedicalRecord.setBirthDate("03/07/98");
		newMedicalRecord.setMedications(medications);
		newMedicalRecord.setAllergies(allergies);

		//Act
		medicalRecordService.updateMedicalRecord(newMedicalRecord);
		MedicalRecord updatedMedicalRecord = medicalRecordService.getMedicalRecordsByName("John", "Boyd");
	  
		//Assert
		assertEquals(updatedMedicalRecord.getBirthDate(), "03/07/98");
		assertEquals(updatedMedicalRecord.getMedications(), medications);
		assertEquals(updatedMedicalRecord.getAllergies(), allergies);
		
			
	}
	
	@Test
	public void deletePersonMedicalRecord_successfullyDeletedPersonMedicalRecord(){
		
		//Arrange
//		MedicalRecord medicalRecord = new MedicalRecord();
//		medicalRecord.setFirstName("John");
//		medicalRecord.setLastName("Boyd");
//		
		//Act
		MedicalRecordService.deleteMedicalRecord("John", "Boyd");
		
		
		//Assert
	    assertEquals(medicalRecordService.getMedicalRecordsByName("John", "Boyd"), null);	
	}
}
