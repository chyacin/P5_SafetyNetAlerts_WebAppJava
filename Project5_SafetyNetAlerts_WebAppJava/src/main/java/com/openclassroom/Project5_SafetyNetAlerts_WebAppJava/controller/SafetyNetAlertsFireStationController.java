package com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.model.FireStation;
import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.service.FireStationService;
import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.utility.ApplicationData;


public class SafetyNetAlertsFireStationController {

	Logger logger = LoggerFactory.getLogger(SafetyNetAlertsFireStationController.class);
	
	
	   //fireStation endPoints
     @PostMapping("/fireStation")
     public void createFireStationAddressMapping(@RequestParam String stationNumber, @RequestParam String address) {
     	
         FireStationService.createFireStationAddressMapping(stationNumber, address);
     	
     }
     
     @PutMapping("/fireStation")
     public void updateAddressFireStationNumber(@RequestBody String address, @RequestBody String stationNumber ) {
     	
     	FireStationService.updateAddressFireStationNumber(stationNumber, address);
     }
     
     @GetMapping("/fireStation")
     public List<FireStation> getFireStation() {
     	
     	logger.info("GET /fireStation called");
     	
     	return ApplicationData.fireStations;
     }
     
     @DeleteMapping("/fireStation")
     public void deleteFireStationAddressMapping(@RequestParam String address, @RequestParam String stationNumber) {
     	
     	   FireStationService.deleteFireStationAddressMapping(address, stationNumber);
     }
}
