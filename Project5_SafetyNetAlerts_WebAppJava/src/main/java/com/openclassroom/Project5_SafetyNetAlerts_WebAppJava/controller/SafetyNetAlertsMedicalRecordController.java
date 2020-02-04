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

import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.model.MedicalRecord;
import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.service.MedicalRecordService;
import com.openclassroom.Project5_SafetyNetAlerts_WebAppJava.utility.ApplicationData;


public class SafetyNetAlertsMedicalRecordController {

	Logger logger = LoggerFactory.getLogger(SafetyNetAlertsMedicalRecordController.class);
	
    //MedicalRecords endPoints
	
    @PostMapping("/medicalRecord")
    public void createMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
    	
    	ApplicationData.medicalRecords.add(medicalRecord);
    }
    
    @PutMapping("/medicalRecord")
    public void updateMedicalRecord(@RequestBody MedicalRecord medicalRecord){
    	MedicalRecordService.updateMedicalRecord(medicalRecord);
    } 
    
    @GetMapping("/medicalRecord")
    public List<MedicalRecord> getMedicalRecord(){
    	
    	logger.info("GET /medicalRecord called");
    	
    	return ApplicationData.medicalRecords;
    }
    
    @DeleteMapping("/medicalRecord")
    public void deleteMedicalRecord(@RequestParam String firstName, @RequestParam String lastName) {
    	
    	MedicalRecordService.deleteMedicalRecord(firstName, lastName);
    }
}
