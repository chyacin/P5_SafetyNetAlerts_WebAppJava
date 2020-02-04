package com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.model;


import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.utility.ApplicationData;



public class Person {
	      @NotBlank(message="Please enter first name")
		  public String firstName; 
	      @NotBlank(message="Please enter last name")
		  public String lastName;
	      @NotBlank(message="Please enter address")
		  public String address;
	      @NotBlank(message="Please enter city")
		  public String city; 
	      @NotBlank(message="Please enter zip")
		  public String zip; 
	      @NotBlank(message="Please enter phone")
		  public String phone; 
	      @NotBlank(message="Please enter email")
		  public String email;
		  
		  
     
   public static class PersonBuilder { 
    	 
	      private String firstName; 
		  private String lastName;
		  private String address;
		  private String city; 
		  private String zip; 
		  private String phone; 
		  private String email;
		  
        public PersonBuilder() {
			
	    } 
	   
		public PersonBuilder firstName(String firstName) {
			   this.firstName = firstName;
			   return this;
		}
		
		public PersonBuilder lastName(String lastName) {
			   this.lastName = lastName;
			   return this;
		}
		
		public PersonBuilder address(String address) {
			   this.address = address;
			   return this;
		}
		
		public PersonBuilder city(String city) {
			   this.city = city;
			   return this;
	    }
		
		public PersonBuilder zip(String zip) {
			   this.zip = zip;
			   return this;
		}
		
		public PersonBuilder phone(String phone) {
			   this.phone = phone;
			   return this;
		}
		
		public PersonBuilder email(String email) {
			   this.email = email;
			   return this;
		}
		
		
   public Person build() {
			return new Person(firstName, lastName, phone, zip, address, city, email);
   }
   
   
  }
   
   public Person() {
	   
   }
   
   public Person(String firstName, String lastName, String phone, String zip, String address, String city, String email) {
		   this.firstName = firstName;
		   this.lastName = lastName;
		   this.phone = phone;
		   this.zip = zip;
		   this.address = address;
		   this.city = city;
		   this.email = email;
   }
		

		private List<Person> person; 
	   
	    public List<Person> getPerson(){
		      return person; 
	    }
			 
	    public void setPerson(List<Person> person){
			  this.person = person;
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


		public String getAddress() {
			   return address;
		}


		public void setAddress(String address) {
			   this.address = address;
		}


		public String getCity() {
			   return city;
		}


		public void setCity(String city) {
			   this.city = city;
		}


		public String getZip() {
			   return zip;
		}


		public void setZip(String zip) {
			   this.zip = zip;
		}


		public String getPhone() {
			   return phone;
		}


		public void setPhone(String phone) {
			   this.phone = phone;
		}


		public String getEmail() {
			   return email;
		}


		public void setEmail(String email) {
			   this.email = email;
		} 
		
		public MedicalRecord getMedicalRecord() {
			List<MedicalRecord> medicalRecords = ApplicationData.medicalRecords;
			
			for(MedicalRecord medicalRecord: medicalRecords) {
				if(medicalRecord.getFirstName().equals(this.firstName)
						&& medicalRecord.getLastName().equals(this.lastName))
					
					return medicalRecord;
			}
			
			return null;
		}
		
		public String getBirthDate() {
			return this.getMedicalRecord().getBirthDate();
		}
		
		public int getAge() {
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/d/yyyy");
			
			LocalDate today = LocalDate.now();
			
			LocalDate birthDate = LocalDate.parse(this.getBirthDate(), formatter);
			
			Period age = Period.between(birthDate, today);
			
			return age.getYears();
		}
		
		
		
		public Set<String> getMedication() {
		       return this.getMedicalRecord().getMedications();
		 }

		public Set<String> getAllergies() {
		       return this.getMedicalRecord().getAllergies();
		}
		
}	 
         
        
		  
		
