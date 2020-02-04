package com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.DataManager;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.model.MedicalRecord;
import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.model.Person;
import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.service.MedicalRecordService;
import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.service.PersonService;
import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.utility.ApplicationData;

@RunWith(MockitoJUnitRunner.class)
public class MedicalRecordServiceTest {
	
	@Mock
	MedicalRecordService medicalRecordService;

	@InjectMocks
	ApplicationData applicationData;
	
	@Test
	public void updatePersonMedicalRecord_returnUpdatedMedicalRecord() {
		
	    //Arrange
		MedicalRecord newMedicalRecord = new MedicalRecord();
		newMedicalRecord.setFirstName("John");
		newMedicalRecord.setLastName("Boyd");
		newMedicalRecord.setBirthDate("03/07/98");
		newMedicalRecord.setMedications(newMedicalRecord.getMedications());
		newMedicalRecord.setAllergies(newMedicalRecord.getAllergies());

		//Act
		MedicalRecordService.updateMedicalRecord(newMedicalRecord);
		
		//Assert
		assertEquals("03/07/98", newMedicalRecord.getBirthDate());
	//	assertEquals("pharmacol:750", newMedicalRecord.getMedications());
	//  assertEquals("shellfish", newMedicalRecord.getAllergies());
		
		
	}
	
	@Test
	public void deletePersonMedicalRecord_successfullyDeletedPersonMedicalRecord(){
		
		//Arrange
		MedicalRecord medicalRecord = new MedicalRecord();
		medicalRecord.setFirstName("John");
		medicalRecord.setLastName("Boyd");
		
		//Act
		MedicalRecordService.deleteMedicalRecord("John", "Boyd");
		
		//Assert
		Mockito.verify(medicalRecordService, times(1));
		
		
		
	}
}
