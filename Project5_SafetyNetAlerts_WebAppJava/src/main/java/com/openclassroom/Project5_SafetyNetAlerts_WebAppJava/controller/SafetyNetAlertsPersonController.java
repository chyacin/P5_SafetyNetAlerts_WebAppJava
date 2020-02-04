package com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.model.Person;
import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.service.PersonService;
import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.utility.ApplicationData;


public class SafetyNetAlertsPersonController {

	Logger logger = LoggerFactory.getLogger(SafetyNetAlertsPersonController.class);
	
	//Person endPoints
	
    @PostMapping("/person")
    public void createPerson(@RequestBody @Valid Person person, BindingResult bindingResult) {
    	
    	if(!bindingResult.hasErrors()) {
    		ApplicationData.persons.add(person);	
    	} 
    }
    
    @PutMapping("/person")
    public void updatePerson(@RequestBody Person person) {
    	
    	  PersonService.updatePerson(person);
    }

    @GetMapping("/person")
	public List<Person> getAllPersons() {
    	
    	logger.info("GET /person called");
    	
    	return ApplicationData.persons;
    }
    
    @DeleteMapping("/person")
    public void deletePerson(@RequestParam String firstName, @RequestParam String lastName) {
    	
    	   PersonService.deletePerson(firstName, lastName);
    }

}
