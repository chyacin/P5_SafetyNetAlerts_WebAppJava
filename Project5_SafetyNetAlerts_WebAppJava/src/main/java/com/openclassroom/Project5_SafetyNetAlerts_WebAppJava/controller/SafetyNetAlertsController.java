package com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.json.simple.JSONObject;

import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.utility.DataManager;


@RestController
public class SafetyNetAlertsController {
                 
        //URL endPoints
        @GetMapping("/firestation")
        public JSONObject getPersonByStationNumber(@RequestParam String stationNumber) 
        {
    	       return DataManager.getPersonDetailsFromFireStation(stationNumber);
        }

        @GetMapping("/childAlert")	
        public JSONObject getChildrenAlert(@RequestParam String address) 
        {
	         return DataManager.getChildrenFromEachAddress(address);
        }

        @GetMapping("/phoneAlert")
        public List<String> getPersonsByPhoneAlert(@RequestParam String stationNumber) 
        {
	           return DataManager.getPhoneNumbersFromFireStation(stationNumber);
        }		
	
        @GetMapping("/fire")
        public JSONObject getPersonByAddress(@RequestParam String address) 
        {
	           return DataManager.getAddressFromEachStationNumber(address);
	
        }
	
        @GetMapping("/stations")
        public List<JSONObject> getPersonByFireStationNumber(@RequestParam String stationNumber) 
        {
    	       return DataManager.getHouseholdsPlusStation(stationNumber);
        }
  

        @GetMapping("/personInfo")
	    public List<JSONObject> getPersonByInfo(@RequestParam String firstName, @RequestParam String lastName)
        {
	           return DataManager.getPersonInfo(firstName, lastName);
        }
	

        @GetMapping("/communityEmail")
        public List<String> getCommunityEmail(@RequestParam String city)	
        {
               return DataManager.getPersonsEmailAddress(city);
        }


}
