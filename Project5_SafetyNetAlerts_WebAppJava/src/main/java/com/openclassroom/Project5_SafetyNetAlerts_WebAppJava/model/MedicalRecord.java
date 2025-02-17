package com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.model;


import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class MedicalRecord {
	
	public MedicalRecord() {
		
	}

    private String firstName;
    private String lastName;
    private String birthDate;

    private Set<String> medications = new HashSet<>();
    private Set<String> allergies = new HashSet<>();

    public MedicalRecord(String firstName, String lastName, String birthDate) {
           this.firstName = firstName;
           this.lastName = lastName;
           this.birthDate = birthDate;

    }

    public MedicalRecord addMedication(String medication) {
           medications.add(medication);
           return this;
    }

    public MedicalRecord addAllergies(String allergy) {
           allergies.add(allergy);
           return this;
    }

    public String getFirstName() {
           return firstName;
    }
    
    public void setFirstName(String firstName) {
    	  this.firstName = firstName;
    }

    public String getLastName() {
           return lastName;
    }
    
    public void setLastName(String lastName) {
    	   this.lastName = lastName;
    }

    public String getName() {
           return firstName.concat(" ") + lastName;
    }

    
    public String getBirthDate() {
           return birthDate;
    }
    
    public void setBirthDate(String birthDate) {
    	this.birthDate = birthDate;
    }

    public Set<String> getMedications() {
           return medications.stream().collect(Collectors.toSet());
    }
    
    public void setMedications(Set<String> medications) {
    	  this.medications = medications;
    }

    public Set<String> getAllergies() {
           return allergies.stream().collect(Collectors.toSet());
    }
    
    public void setAllergies(Set<String> allergies) {
    	   this.allergies = allergies;
    }


@Override
    public String toString() {
           return this.getName().concat(": ") + String.join(", medications :", medications) + String.join(", Allergies : ", allergies);
    }

}


