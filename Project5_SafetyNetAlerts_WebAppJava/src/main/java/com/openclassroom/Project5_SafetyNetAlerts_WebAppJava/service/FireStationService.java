package com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.service;

import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.model.FireStation;
import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.utility.ApplicationData;


public class FireStationService {

	   //ENDPOINTS
			//(fireStation)
			 
			 
			 public static void createFireStationAddressMapping(String stationNumber, String address) {
			    	
			    	for(FireStation fireStation: ApplicationData.fireStations) {
						 if(fireStation.getStationNumber().equals(stationNumber)) {
							 
							 fireStation.addAddress(address);
					     }
				    }
			    }	 
			 
			 public static void updateAddressFireStationNumber(String stationNumber, String address) {
				 
				 for(FireStation fireStation: ApplicationData.fireStations) {
					 if(fireStation.getAddresses().contains(address)) {
						 
						 fireStation.removeAddress(address);
						 
					 }
					 
				 }
				 
				 for(FireStation fireStation: ApplicationData.fireStations) {
					 if(fireStation.getStationNumber().equals(stationNumber)) {
						 
						 fireStation.addAddress(address);
						 return;
					 }
				}
				 
				 FireStation fireStation = new FireStation(stationNumber);
				 fireStation.addAddress(address);
				 ApplicationData.fireStations.add(fireStation);
				 
			 }
			 
		
			 
		    public static void deleteFireStationAddressMapping(String stationNumber, String address) {
		    	
		    	for(FireStation fireStation: ApplicationData.fireStations) {
					 if(fireStation.getStationNumber().equals(stationNumber)) {
						 
						 fireStation.removeAddress(address);
				     }
			    }
		    }	 
}
