package com.openclassroom.safetynetalerts.datafile.model;

import java.util.List;




public class firestations{
	
	public static class  FirestationsBuilder {
		
		
		  private List<firestations> firestations; 

		  public List<firestations> getFirestations(){
		  	return firestations; 
		  }
		  public void setFirestations(List<firestations> input){
		  	 this.firestations = input;
		  }
	
	}	
		  private String address; 
		  
		  private String station; 

		  public String getAddress(){
		  	return address; 
		  }
		  
		  public void setAddress(String address){
		  	 this.address = address;
		  }
		  
		  public String getStation(){
		  	return station; 
		  }
		  
		  public void setStation(String station){
		  	 this.station = station;
		  }
	}
	
	  


