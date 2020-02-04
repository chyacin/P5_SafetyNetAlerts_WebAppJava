package com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.model;
 

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.utility.ApplicationData;




public class FireStation {
	
	public FireStation() {
		
	}
	
	private Set<String> addresses = new HashSet<>();
	
	private String stationNumber;
	private String address;

	public FireStation(String stationNumber) {
	       this.stationNumber = stationNumber;
	}

	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public FireStation addAddress(String address) {
	       addresses.add(address);
	       return this;
	}

	public String getStationNumber() {
	       return stationNumber;
	}
	
	public void setStationNumber(String stationNumber) {
		 this.stationNumber = stationNumber;
	}

	public Set<String> getAddresses() {
	       return addresses.stream().collect(Collectors.toSet());
	}

	@Override
	public String toString() {
	       return stationNumber.concat(": ") + String.join(", ", addresses);
	}
	
	
	
	public void removeAddress(String address) {
		
		addresses.remove(address);
		
	}
	
	public List<Person> getPersonsInEachStation(){
		
		List<Person> allPersons = ApplicationData.persons;
		
		List<Person> personsInEachFireStation = new ArrayList<>();
		
		for(Person person: allPersons) {
			if(this.addresses.contains(person.address))
				personsInEachFireStation.add(person);
				
		}
		return personsInEachFireStation;
	}

	
	
	
	public int getNumberOfAdults() {
		
		List<Person> persons = ApplicationData.persons;
		
		int numberOfAdults = 0;
		
		for(Person person: persons) {
			if(person.getAge()>18) {
				numberOfAdults++;
		
			}
			
		}
		return numberOfAdults;
	}
	
	public int getNumberOfChildren() {
		
		List<Person> persons = ApplicationData.persons;

		int numberOfChildren = 0;
		
		for(Person person: persons) {
			if(person.getAge()<=18) {
				numberOfChildren++;
			}
		}
		return numberOfChildren;
	}
}
