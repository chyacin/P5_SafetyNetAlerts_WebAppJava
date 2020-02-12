package com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.utility;

import java.util.ArrayList;
import java.util.List;

import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.model.FireStation;
import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.model.MedicalRecord;
import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.model.Person;

public class ApplicationData {
	
	private static List<Person> persons = new ArrayList<>();
	private static List<FireStation> fireStations = new ArrayList<>();
	private static List<MedicalRecord> medicalRecords = new ArrayList<>();
	
    public ApplicationData() {
    	
    }
	
    public ApplicationData(List<Person> persons, List<FireStation> fireStations, List<MedicalRecord> medicalRecords) {
    	this.persons = persons;
    	this.fireStations = fireStations;
    	this.medicalRecords = medicalRecords;
    	
    }
    
	public static List<Person> getPersons() {
		return persons;
	}
	
	public static void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	
	public static List<FireStation> getFireStations() {
		return fireStations;
	}
	
	public static void setFireStation(List<FireStation> fireStations) {
		this.fireStations = fireStations;
	}
	
	public static List<MedicalRecord> getMedicalRecord(){
		return medicalRecords;
	}
	
	public static void setMedicalRecord(List<MedicalRecord> medicalRecords) {
		this.medicalRecords = medicalRecords; 
	}
}
