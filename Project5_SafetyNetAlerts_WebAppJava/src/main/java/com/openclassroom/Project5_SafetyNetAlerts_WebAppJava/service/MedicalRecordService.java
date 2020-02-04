package com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.service;

import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.model.MedicalRecord;
import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.utility.ApplicationData;


public class MedicalRecordService {

	//ENDPOINTS(MedicalRecord)
    
    public static void updateMedicalRecord(MedicalRecord newMedicalRecord) {
    	 
    	for(MedicalRecord medicalRecord: ApplicationData.medicalRecords) {
    		if(medicalRecord.getName().equals(newMedicalRecord.getName())) {
    	
    		
				medicalRecord.setBirthDate(newMedicalRecord.getBirthDate());
				medicalRecord.setMedications(newMedicalRecord.getMedications());
				medicalRecord.setAllergies(newMedicalRecord.getAllergies());
			}	
    	}	
    }
    
    public static void deleteMedicalRecord(String firstName, String lastName){
		 
		 for(MedicalRecord medicalRecord: ApplicationData.medicalRecords) {
				if(medicalRecord.getFirstName().equals(firstName)
				   && medicalRecord.getLastName().equals(lastName)) {
					
				   ApplicationData.medicalRecords.remove(medicalRecord);
				}
		}
		 
	}  
}
