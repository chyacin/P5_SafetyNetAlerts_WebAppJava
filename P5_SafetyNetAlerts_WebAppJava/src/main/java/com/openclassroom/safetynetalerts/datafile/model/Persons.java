package com.openclassroom.safetynetalerts.datafile.model;

import java.util.List;

import com.openclassroom.safetynetalerts.datafile.controller.*;

public class Persons {
	
	public static class PersonsBuilder {
		
	
		  private List<Persons> persons; 

		  public List<Persons> getPersons(){
		  	return persons; 
		  }
		  public void setPersons(List<Persons> persons){
		  	 this.persons = persons;
		  }
}
	
	  private String firstName; 
	  
	  private String lastName;
	  
	  private String address;
	  
	  private String city; 
	  
	  private String zip; 
	  
	  private String phone; 
	  
	  private String email; 
	  

	  public String getFirstName(){
	  	return firstName; 
	  }
	  
	  public void setFirstName(String firstName){
	  	 this.firstName = firstName;
	  }
	  
	  public String getLastName(){
	  	return lastName; 
	  }
	  
	  public void setLastName(String lastName){
	  	 this.lastName = lastName;
	  }
	  
	  public String getAddress(){
	  	return address; 
	  }
	  
	  public void setAddress(String address){
	  	 this.address = address;
	  }
	  
	  public String getCity(){
	  	return city; 
	  }
	  
	  public void setCity(String city){
	  	 this.city = city;
	  }
	  
	  public String getZip(){
	  	return zip; 
	  }
	  
	  public void setZip(String zip){
	  	 this.zip = zip;
	  }
	  
	  public String getPhone(){
	  	return phone; 
	  }
	  
	  public void setPhone(String phone){
	  	 this.phone = phone;
	  }
	  
	  public String getEmail(){
	  	return email; 
	  }
	  
	  public void setEmail(String email){
	  	 this.email = email;
	  }
}


  

